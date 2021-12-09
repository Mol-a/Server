package condorcet.Utility;

import com.google.gson.Gson;
import condorcet.DepositList.DepositDOM;
import condorcet.Enums.ResponseStatus;
import condorcet.Models.Entities.*;
import condorcet.Models.TCP.Request;
import condorcet.Models.TCP.Response;
import condorcet.Models.TransferModel;
import condorcet.Services.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientThread implements Runnable {
    private final Socket clientSocket;
    private Request request;
    private Response response;
    private final Gson gson;
    private final BufferedReader in;
    private final PrintWriter out;
    private final UserService userService = new UserService();
    private final PersonDataService personDataService = new PersonDataService();
    private final ClientService clientService = new ClientService();
    private final DepositService depositService = new DepositService();
    private final AccountService accountService = new AccountService();
    private final CreditService creditService = new CreditService();
    private final CardService cardService = new CardService();

    public ClientThread(Socket clientSocket) throws IOException {
        response = new Response();
        request = new Request();
        this.clientSocket = clientSocket;
        gson = new Gson();//ObjectMapper
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (clientSocket.isConnected()) {
                String message = in.readLine();
                request = gson.fromJson(message, Request.class);
                List<User> allEntities = userService.findAllEntities();
                switch (request.getRequestType()) {
                    case REGISTER: {
                        User user = gson.fromJson(request.getRequestMessage(), User.class);
                        if (allEntities.stream().noneMatch(x -> x.getLogin().toLowerCase().equals(user.getLogin().toLowerCase()))) {
                            personDataService.saveEntity(user.getPersonData());
                            userService.saveEntity(user);
                            User returnUser = userService.findEntity(user.getId());
                            response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(returnUser));
                        } else {
                            response = new Response(ResponseStatus.ERROR, "Такой пользователь уже существует!", "");
                        }
                        break;
                    }
                    case LOGIN: {
                        User requestUser = gson.fromJson(request.getRequestMessage(), User.class);
                        if (allEntities.stream().
                                anyMatch(x -> x.getLogin().equalsIgnoreCase(requestUser.getLogin()))
                                && allEntities.stream().anyMatch(x -> new BCryptPasswordEncoder().matches(requestUser.getPassword(), x.getPassword()))) {
                            User user = allEntities.stream().filter(x -> x.getLogin().equalsIgnoreCase(requestUser.getLogin())).findFirst().get();
                            user = userService.findEntity(user.getId());
                            response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(user));
                        } else {
                            response = new Response(ResponseStatus.ERROR, "Такого пользователя не существует или неправильный пароль!", "");
                        }

                        break;
                    }
                    case ADD_CLIENT:
                        Client client = gson.fromJson(request.getRequestMessage(), Client.class);
                        clientService.saveEntity(client);
                        response = new Response(ResponseStatus.OK, "Готово!", "");
                        break;
                    case GETALL_DEPOSITS:
                        DepositDOM dom = new DepositDOM();
                        response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(dom.unmarshall()));
                        break;
                    case ADD_DEPOSIT:
                        Deposit deposit = gson.fromJson(request.getRequestMessage(), Deposit.class);
                        depositService.saveEntity(deposit);
                        response = new Response(ResponseStatus.OK, "Готово!", "");
                        break;
                    case GETALL_CARDS:
                        response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(cardService.findAllEntities()));
                        break;
                    case GETALL_ACCOUNTS:
                        response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(accountService.findAllEntities()));
                        break;
                    case GET_CREDITS:
                        response = new Response(ResponseStatus.OK, "Готово!", gson.toJson(creditService.findAllEntities()));
                        break;
                    case AMOUNT_TRANSFER:
                        TransferModel transfer = gson.fromJson(request.getRequestMessage(), TransferModel.class);
                        List<Card> cards1 = cardService.findAllEntities();
                        for (Card card : cards1) {
                            if (card.getCard_number() == transfer.getFrom_number()) {
                                card.setCard_amount(card.getCard_amount() - transfer.getAmount());
                                cardService.updateEntity(card);
                            } else {
                                // response = new Response(ResponseStatus.ERROR, "Готово!","");
                            }
                        }
                        for (Card card : cards1) {
                            if (card.getCard_number() == transfer.getTo_number()) {
                                card.setCard_amount(card.getCard_amount() + transfer.getAmount());
                                cardService.updateEntity(card);
                            } else {
                                // response = new Response(ResponseStatus.ERROR, "Готово!","");
                            }
                        }
                        response = new Response(ResponseStatus.OK, "Готово!", "");
                        break;
                    case AMOUNT_TRANSFER_CARD_ACCOUNT:
                        TransferModel transferModel = gson.fromJson(request.getRequestMessage(), TransferModel.class);
                        List<Card> cards = cardService.findAllEntities();
                        for (Card card : cards) {
                            if (card.getCard_number() == transferModel.getFrom_number()) {
                                card.setCard_amount(card.getCard_amount() - transferModel.getAmount());
                                cardService.updateEntity(card);
                            }
                        }
                        List<Account> accounts = accountService.findAllEntities();
                        for (Account account : accounts) {
                            if (account.getAccount_number() == transferModel.getTo_number()) {
                                double first = transferModel.getAmount();
                                account.setAmount(account.getAmount() + first);
                                accountService.updateEntity(account);
                            }
                        }
                        response = new Response(ResponseStatus.OK, "Готово!", "");
                        break;
                    case AMOUNT_TRANSFER_ACCOUNT_CARD:
                        TransferModel transferModel1 = gson.fromJson(request.getRequestMessage(), TransferModel.class);
                        List<Account> accounts1 = accountService.findAllEntities();
                        for (Account account : accounts1) {
                            if (account.getAccount_number() == transferModel1.getFrom_number()) {
                                account.setAmount(account.getAmount() - transferModel1.getAmount());
                                accountService.updateEntity(account);
                            }
                        }
                        List<Card> cardsList = cardService.findAllEntities();
                        for (Card card : cardsList) {
                            if (card.getCard_number() == transferModel1.getTo_number()) {
                                card.setCard_amount(card.getCard_amount() + transferModel1.getAmount());
                                cardService.updateEntity(card);
                            }
                        }
                        response = new Response(ResponseStatus.OK, "Готово!", "");
                        break;
                    case AMOUNT_TRANSFER_ACCOUNT_ACCOUNT:
                        TransferModel transferModel2 = gson.fromJson(request.getRequestMessage(), TransferModel.class);
                        List<Account> accounts2 = accountService.findAllEntities();
                        for (Account account : accounts2) {
                            if (account.getAccount_number() == transferModel2.getFrom_number()) {
                                account.setAmount(account.getAmount() - transferModel2.getAmount());
                                accountService.updateEntity(account);
                            }
                        }
                        for (Account account : accounts2) {
                            if (account.getAccount_number() == transferModel2.getFrom_number()) {
                                account.setAmount(account.getAmount() - transferModel2.getAmount());
                                accountService.updateEntity(account);
                            }
                        }
                        break;

                }
                out.println(gson.toJson(response));
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " закрыл соединение.");
            try {

                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


package condorcet.Services;

import condorcet.DataAccessObjects.ClientDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Account;
import condorcet.Models.Entities.Client;
import condorcet.Models.Entities.User;

import java.util.List;

public class ClientService implements Service<Client> {
    DAO daoService = new ClientDAO();

    @Override
    public Client findEntity(int id) {
        Client entity = (Client) daoService.findById(id);
        if(entity.getPersonData() != null){
            entity.getPersonData().setUsers(null);
        }

        for (Account account : entity.getAccounts()){
            if (account.getClient() != null){
                account.getClient().setAccounts(null);
            }
        }
        return entity;
    }

    @Override
    public void saveEntity(Client entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Client entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Client entity) {
        daoService.update(entity);
    }

    @Override
    public List<Client> findAllEntities() {
        return daoService.findAll();
    }
}

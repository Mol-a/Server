package condorcet.Services;

import condorcet.DataAccessObjects.AccountDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Account;
import condorcet.Models.Entities.Deposit;

import java.util.List;

public class AccountService implements Service<Account> {
    DAO daoService = new AccountDAO();

    @Override
    public Account findEntity(int id) {
        Account entity = (Account) daoService.findById(id);
        for (Deposit deposits : entity.getDeposit()){
            if (deposits.getAccount() != null) {
                deposits.getAccount().setDeposit(null);
            }
        }
        if (entity.getClient() != null){
            entity.getClient().setPersonData(null);
            entity.getClient().getPersonData().setUsers(null);

        }
        return entity;
    }

    @Override
    public void saveEntity(Account entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Account entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Account entity) {
        daoService.update(entity);
    }

    @Override
    public List<Account> findAllEntities() {
        return daoService.findAll();
    }
}

package condorcet.Services;

import condorcet.DataAccessObjects.AccountDAO;
import condorcet.DataAccessObjects.DepositDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Deposit;

import java.util.List;

public class DepositService implements Service<Deposit> {
    DAO daoService = new DepositDAO();

    @Override
    public Deposit findEntity(int id) {
        Deposit entity = (Deposit) daoService.findById(id);
        if (entity.getAccount() != null) {
            entity.getAccount().setDeposit(null);
            entity.getAccount().setClient(null);

        }
        return entity;
    }

    @Override
    public void saveEntity(Deposit entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Deposit entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Deposit entity) {
        daoService.update(entity);
    }

    @Override
    public List<Deposit> findAllEntities() {
        return daoService.findAll();
    }
}

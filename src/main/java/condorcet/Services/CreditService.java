package condorcet.Services;

import condorcet.DataAccessObjects.CreditDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Credit;

import java.util.List;

public class CreditService implements Service<Credit> {
    private final DAO<Credit> daoService;

    public CreditService() {
        daoService = new CreditDAO();
    }

    @Override
    public Credit findEntity(int id) {
        return daoService.findById(id);
    }

    @Override
    public void saveEntity(Credit entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Credit entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Credit entity) {
        daoService.update(entity);
    }

    @Override
    public List<Credit> findAllEntities() {
        return daoService.findAll();
    }
}
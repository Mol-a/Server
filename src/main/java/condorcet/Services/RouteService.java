package condorcet.Services;

import condorcet.DataAccessObjects.RouteDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Route;

import java.util.List;

public class RouteService implements Service<Route> {
    DAO daoService = new RouteDAO();

    @Override
    public Route findEntity(int id) {
        Route entity = (Route) daoService.findById(id);
        return entity;
    }
    @Override
    public void saveEntity(Route entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Route entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Route entity) {
        daoService.update(entity);
    }

    @Override
    public List<Route> findAllEntities() {
        return daoService.findAll();
    }
}

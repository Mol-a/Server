package condorcet.Services;

import condorcet.DataAccessObjects.PersonDataDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Client;
import condorcet.Models.Entities.PersonData;
import condorcet.Models.Entities.User;

import java.util.List;

public class PersonDataService implements Service<PersonData> {
    DAO daoService = new PersonDataDAO();

    @Override
    public PersonData findEntity(int id) {
        PersonData entity = (PersonData) daoService.findById(id);
        for (Client client : entity.getClients()) {
            if (client.getPersonData() != null) {
                client.getPersonData().setClients(null);
            }
        }
        for (User user : entity.getUsers()) {
            if (user.getPersonData() != null) {
                user.getPersonData().setUsers(null);
            }
        }
        return entity;
    }

    @Override
    public void saveEntity(PersonData entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(PersonData entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(PersonData entity) {
        daoService.update(entity);
    }

    @Override
    public List<PersonData> findAllEntities() {
        return daoService.findAll();
    }
}

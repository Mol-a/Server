package condorcet.Services;

import condorcet.DataAccessObjects.UserDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Client;
import condorcet.Models.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {
    DAO daoService = new UserDAO();
    @Override
    public User findEntity(int id) {
        User entity = (User) daoService.findById(id);
        if (entity.getPersonData() != null) {
            for (Client client : entity.getPersonData().getClients()) {
                client.setPersonData(null);
                if (client.getAccounts()!=null) {
                client.setAccounts(null);
                }
                /*client.setAccounts(null);*/
            }
            entity.getPersonData().setUsers(null);
        }
        return entity;
    }

    @Override
    public void saveEntity(User entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(User entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(User entity) {
        daoService.update(entity);
    }

    @Override
    public List<User> findAllEntities() {
        List<User> users =  daoService.findAll();
        List<User> tempUsers = new ArrayList<>();
        UserService userService = new UserService();
        for (User tempUser : users) {
            tempUser = userService.findEntity(tempUser.getId());
            tempUsers.add(tempUser);
        }
        return tempUsers;
    }
}

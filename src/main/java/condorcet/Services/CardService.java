package condorcet.Services;

import condorcet.DataAccessObjects.CardDAO;
import condorcet.DataAccessObjects.DepositDAO;
import condorcet.Interfaces.DAO;
import condorcet.Interfaces.Service;
import condorcet.Models.Entities.Card;
import condorcet.Models.Entities.Deposit;

import java.util.List;

public class CardService implements Service<Card> {
    DAO daoService = new CardDAO();

    @Override
    public Card findEntity(int id) {
        Card entity = (Card) daoService.findById(id);
        if (entity.getAccount() != null) {
            entity.getAccount().setClient(null);
            entity.getAccount().getClient().setPersonData(null);
            entity.getAccount().getClient().getPersonData().setUsers(null);
        }
        return entity;
    }

    @Override
    public void saveEntity(Card entity) {
        daoService.save(entity);
    }

    @Override
    public void deleteEntity(Card entity) {
        daoService.delete(entity);
    }

    @Override
    public void updateEntity(Card entity) {
        daoService.update(entity);
    }

    @Override
    public List<Card> findAllEntities() {
        return daoService.findAll();
    }
}

package condorcet.DataAccessObjects;

import condorcet.Interfaces.DAO;
import condorcet.Models.Entities.Card;
import condorcet.Utility.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CardDAO implements DAO {
    @Override
    public void save(Object obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Object obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Object obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        // session.delete(obj);
        session.remove(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public Object findById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Card card = session.get(Card.class, id);
        session.close();
        return card;
    }

    @Override
    public List<Object> findAll() {
        Session session =   HibernateSessionFactory.getSessionFactory().openSession();
        List<Object> cards = (List<Object>)session.createQuery("From Card").list();
        session.close();
        return cards;
    }
/*
    public List<Card> get_cards (int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

    }*/

}

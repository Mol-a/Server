package condorcet.DataAccessObjects;

import condorcet.Interfaces.DAO;
import condorcet.Models.Entities.Deposit;
import condorcet.Utility.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepositDAO implements DAO<Deposit> {
    @Override
    public void save(Deposit obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Deposit obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Deposit obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        // session.delete(obj);
        session.remove(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public Deposit findById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Deposit aircraft = session.get(Deposit.class, id);
        session.close();
        return aircraft;
    }

    @Override
    public List<Deposit> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Deposit> deposits = session.createQuery("From Deposit").list();
        session.close();
        return deposits;
    }
}

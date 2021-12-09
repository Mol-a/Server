package condorcet.DataAccessObjects;

import condorcet.Interfaces.DAO;
import condorcet.Models.Entities.Account;
import condorcet.Utility.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDAO implements DAO<Account> {
    @Override
    public void save(Account obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Account obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Account obj) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        // session.delete(obj);
        session.remove(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public Account findById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Account aircraft = session.get(Account.class, id);
        session.close();
        return aircraft;
    }

    @Override
    public List<Account> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("From Account").list();
        session.close();
        return accounts;
    }
}

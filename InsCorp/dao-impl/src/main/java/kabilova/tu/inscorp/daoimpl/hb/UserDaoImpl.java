package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import kabilova.tu.inscorp.model.user.User;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User loadUser(String username, String password) {
        if (username == null || username.equals("")) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (password == null || password.equals("")) {
            throw new IllegalArgumentException("Invalid password");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> user = session
                                .createCriteria(User.class)
                                .add(Restrictions.like("username", username))
                                .add(Restrictions.like("password", password))
                                .list();

        if (user.size() > 1) {
            throw new IllegalArgumentException("..."); //TODO
        }

        return user.get(0);
    }

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List<User> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> user = session
                .createCriteria(User.class)
                .list();
        return user;
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
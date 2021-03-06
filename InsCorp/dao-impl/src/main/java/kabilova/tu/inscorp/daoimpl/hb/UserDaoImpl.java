package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscorp.model.user.Insurer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User loadUser(String username, String password) throws InsCorpException {
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

        if (user.size() < 1) {
            throw new InsCorpException("Няма намерен потребител!");
        }

        return user.get(0);
    }

    @Override
    public void create(User user) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            throw new InsCorpException("Съществуваща уникална стойност!");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List user = session
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
    public void delete(User user) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.delete(user);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            throw new InsCorpException("Невъзможно изтриване на потребител, който има заведени застраховки!");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public User loadByUsername(String username) throws InsCorpException {
        if (username == null || username.equals("")) {
            throw new IllegalArgumentException("Invalid username");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> user = session
                .createCriteria(User.class)
                .add(Restrictions.like("username", username))
                .list();

        if (user.size() < 1) {
            throw new InsCorpException("Няма намерен потребител!");
        }

        return user.get(0);
    }

    @Override
    public User loadByEGN(String egn) throws InsCorpException {
        if (egn == null || egn.equals("")) {
            throw new IllegalArgumentException("Invalid egn");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> user = session
                .createCriteria(User.class)
                .add(Restrictions.like("egn", egn))
                .list();

        if (user.size() < 1) {
            throw new InsCorpException("Няма намерен потребител!");
        }

        return user.get(0);
    }

    @Override
    public List<Insurer> readInsurers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Insurer> user = session
                .createCriteria(Insurer.class)
                .list();
        return user;
    }

    @Override
    public List<Insured> readInsured() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Insured> insureds = session
                .createCriteria(Insured.class)
                .list();
        return insureds;
    }
}
package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class PolicyDaoImpl implements PolicyDao {
    @Override
    public void create(Policy policy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.save(policy);
            session.getTransaction().commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List<Policy> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Policy> policies = session
                .createCriteria(Policy.class)
                .list();
        return policies;
    }

    @Override
    public void update(Policy policy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.update(policy);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(Policy policy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.delete(policy);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List loadActivePolicies(User user, Calendar currentDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Policy> policies = session
                .createCriteria(Policy.class)
                .add(Restrictions.eq("insured", user))
                .add(Restrictions.ge("dateTo", Calendar.getInstance()))
                .list();

        if(policies.size() < 1) {
            throw  new IllegalArgumentException("cannot find policies");
        }
        return policies;
    }
}

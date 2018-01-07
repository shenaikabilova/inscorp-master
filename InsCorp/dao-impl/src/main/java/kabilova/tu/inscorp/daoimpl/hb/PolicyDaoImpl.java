package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.PolicyDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.policy.Policy;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.User;
import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.model.user.Insurer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

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
    public List read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List policies = session
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
    public List loadActivePoliciesGO(User user, Calendar currentDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Policy> policies = session
                .createCriteria(GO.class)
                .add(Restrictions.eq("insured", user))
                .add(Restrictions.ge("dateTo", Calendar.getInstance()))
                .list();

        return policies;
    }

    @Override
    public List loadActivePoliciesKasko(User user, Calendar currentDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Policy> policies = session
                .createCriteria(Kasko.class)
                .add(Restrictions.eq("insured", user))
                .add(Restrictions.ge("dateTo", Calendar.getInstance()))
                .list();

        return policies;
    }

    @Override
    public List<GO> loadPoliciesGO(User user) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<GO> policies = null;

        if(user instanceof Insurer) {
            policies = session
                    .createCriteria(GO.class)
                    .add(Restrictions.eq("insurer", user))
                    .list();
        } else if(user instanceof Insured) {
            policies = session
                    .createCriteria(GO.class)
                    .add(Restrictions.eq("insured", user))
                    .list();
        }
        if(policies.size() < 1) {
            throw new InsCorpException("Съществуваща уникална стойност!");
        }
        return policies;
    }

    @Override
    public List<Kasko> loadPoliciesKasko(User user) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Kasko> policies = null;
        if(user instanceof Insurer) {
            policies = session
                    .createCriteria(Kasko.class)
                    .add(Restrictions.eq("insurer", user))
                    .list();
        } else if(user instanceof Insured) {
            policies = session
                    .createCriteria(Kasko.class)
                    .add(Restrictions.eq("insured", user))
                    .list();
        }
        if(policies.size() < 1) {
            throw new InsCorpException("Съществуваща уникална стойност!");
        }
        return policies;
    }

    @Override
    public List<GO> loadAllGO() throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<GO> policies =  session
                    .createCriteria(GO.class)
                    .list();
        if(policies.size() < 1) {
            throw new InsCorpException("Съществуваща уникална стойност!");
        }
        return policies;
    }

    @Override
    public List<Kasko> loadAllKasko() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Kasko> policies = session
                    .createCriteria(Kasko.class)
                    .list();
        if(policies.size() < 1) {
            throw  new IllegalArgumentException("cannot find policies");
        }
        return policies;
    }

    @Override
    public String getLastPolicyID() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Policy policies = (Policy) session
                .createCriteria(Policy.class)
                .addOrder(Order.desc("policaID"))
                .setMaxResults(1)
                .uniqueResult();

        return policies.getPolicaID();
    }

    @Override
    public Policy getPolicaByPolicaNum(String policaNum) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Policy> policies = session
                .createCriteria(Policy.class)
                .add(Restrictions.eq("policaID", policaNum))
                .list();

        if (policies.size() < 1) {
            throw new InsCorpException("Не е намерена полица!");
        }
        return policies.get(0);
    }
}

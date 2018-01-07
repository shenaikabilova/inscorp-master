package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtypeDaoImpl implements CrudDao<VehicleSubtype> {
    @Override
    public void create(VehicleSubtype vehicleSubtype) throws InsCorpException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(vehicleSubtype);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            throw new InsCorpException("Съществуваща уникална стойност!");
        } catch (HibernateException e)     {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }

    }

    @Override
    public List<VehicleSubtype> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<VehicleSubtype> vehicleSubtypes = session.createCriteria(VehicleSubtype.class).list();
        return vehicleSubtypes;
    }

    @Override
    public void update(VehicleSubtype vehicleSubtype) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.update(vehicleSubtype);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(VehicleSubtype vehicleSubtype) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.delete(vehicleSubtype);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}

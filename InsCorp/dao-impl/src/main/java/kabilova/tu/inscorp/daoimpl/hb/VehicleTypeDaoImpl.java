package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.CrudDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleTypeDaoImpl implements CrudDao<VehicleType> {

    @Override
    public void create(VehicleType vehicleType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(vehicleType);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List<VehicleType> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<VehicleType> vehicleTypes = session.createCriteria(VehicleType.class).list();
        return vehicleTypes;
    }

    @Override
    public void update(VehicleType vehicleType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.update(vehicleType);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(VehicleType vehicleType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.delete(vehicleType);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}

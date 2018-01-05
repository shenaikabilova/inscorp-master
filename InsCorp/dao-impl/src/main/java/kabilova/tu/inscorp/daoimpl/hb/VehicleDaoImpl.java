package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.VehicleDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleDaoImpl implements VehicleDao {
    @Override
    public void create(Vehicle vehicle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            session.save(vehicle);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public List<Vehicle> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Vehicle> vehicles = session.createCriteria(Vehicle.class).list();
        return vehicles;
    }

    @Override
    public void update(Vehicle vehicle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.update(vehicle);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.delete(vehicle);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public Vehicle loadVehicle(String regNumber) {
        if(regNumber == null || regNumber.equals("")) {
            throw new IllegalArgumentException("Invalid registration number");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Vehicle> vehicle = session.createCriteria(Vehicle.class)
                               .add(Restrictions.like("regNum", regNumber))
                               .list();

        if(vehicle.size() < 1 ){
            throw  new IllegalArgumentException("cannot find vehicle"); //TODO
        }

        return vehicle.get(0);
    }

    @Override
    public List<Vehicle> loadVehicleByUser(Insured insured) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Vehicle> vehicles = session
                .createCriteria(Vehicle.class)
                .add(Restrictions.like("insured", insured))
                .list();

        if(vehicles.size() < 1) {
            throw new IllegalArgumentException("not result");
        }

        return vehicles;
    }
}

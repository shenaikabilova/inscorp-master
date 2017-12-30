package kabilova.tu.inscorp.daoimpl.hb;

import kabilova.tu.inscorp.dao.TariffDao;
import kabilova.tu.inscorp.daoimpl.hbconfig.HibernateUtil;
import kabilova.tu.inscorp.model.tariff.Tariff;
import kabilova.tu.inscorp.model.tariff.TariffGO;
import kabilova.tu.inscorp.model.tariff.TariffKasko;
import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class TariffDaoImpl implements TariffDao {
    @Override
    public TariffGO loadTariffGo(VehicleSubtype vehicleSubtype, int zone) {
        if (vehicleSubtype == null) {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        if (zone == 0) {
            throw new IllegalArgumentException("Invalid zone");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<TariffGO> tariffGO = session
                .createCriteria(TariffGO.class)
                .add(Restrictions.like("vehicleSubtype", vehicleSubtype))
                .add(Restrictions.like("zone", zone))
                .list();

        if (tariffGO.size() < 1) {
            throw new IllegalArgumentException("..."); //TODO
        }

        return tariffGO.get(0);
    }

    @Override
    public TariffKasko loadTariffkasko(VehicleSubtype vehicleSubtype) {
        return null;
    }

    @Override
    public void create(Tariff tariff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.save(tariff);
            session.getTransaction().commit();
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

        List tariff = session
                .createCriteria(Tariff.class)
                .list();
        return tariff;
    }

    @Override
    public void update(Tariff tariff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.update(tariff);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    @Override
    public void delete(Tariff tariff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try{
            session.delete(tariff);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}

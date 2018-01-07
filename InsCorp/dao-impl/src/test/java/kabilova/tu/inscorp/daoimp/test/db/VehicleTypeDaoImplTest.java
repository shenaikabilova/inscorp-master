package kabilova.tu.inscorp.daoimp.test.db;

import kabilova.tu.inscorp.model.vehicle.VehicleType;
import org.hibernate.Session;
import org.junit.*;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleTypeDaoImplTest {
//    private static Session session;
//    private VehicleType vehicleType = DataTest.getVehicleTypeTest();
//
//    @Before
//    public void before(){
//        session = HibernateUtilTest.getSessionFactory().openSession();
//        session.beginTransaction();
//    }
//
//    @After
//    public void after() {
//        session.clear();
//        HibernateUtilTest.shutdown();
//    }
//
//    @Test
//    public void createVehicleType(){
//        session.save(vehicleType);
//        session.getTransaction().commit();
//
//        Assert.assertEquals(1, vehicleType.getId());
//    }
//
//    @Test
//    public void updateVehicleType(){
//        createVehicleType();
//        vehicleType.setVehicleType("bus");
//        session.update(vehicleType);
//
//        Assert.assertEquals(1, vehicleType.getId());
//        Assert.assertEquals("bus", vehicleType.getVehicleType());
//    }
//
//    @Test
//    public void deleteVehicleType(){
//        createVehicleType();
//        session.delete(vehicleType);
//
//        Assert.assertEquals(1, vehicleType.getId());
//    }
//
//    @Test
//    public void read(){
//        createVehicleType();
//        List<VehicleType> types = session
//                .createCriteria(VehicleType.class)
//                .list();
//
//        Assert.assertTrue(types.size()>0);
//    }
}

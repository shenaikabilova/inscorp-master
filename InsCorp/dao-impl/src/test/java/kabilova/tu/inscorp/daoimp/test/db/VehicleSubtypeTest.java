package kabilova.tu.inscorp.daoimp.test.db;

import kabilova.tu.inscorp.model.vehicle.VehicleSubtype;
import kabilova.tu.inscorp.model.vehicle.VehicleType;
import org.hibernate.Session;
import org.junit.*;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class VehicleSubtypeTest {
//    private static Session session;
//    private VehicleSubtype vehicleSubtype = DataTest.getVehicleSubtypeTest();
//    private VehicleTypeDaoImplTest test = new VehicleTypeDaoImplTest();
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
//        test.createVehicleType();
//        session.save(vehicleSubtype);
//        session.getTransaction().commit();
//
//        Assert.assertEquals(1, vehicleSubtype.getId());
//    }
//
//    @Test
//    public void updateVehicleType(){
//        createVehicleType();
//        vehicleSubtype.setSubtype("subtype");
//        session.update(vehicleSubtype);
//
//        Assert.assertEquals(1, vehicleSubtype.getId());
//        Assert.assertEquals("subtype", vehicleSubtype.getSubtype());
//    }
//
//    @Test
//    public void deleteVehicleType(){
//        createVehicleType();
//        session.delete(vehicleSubtype);
//
//        Assert.assertEquals(1, vehicleSubtype.getId());
//        Assert.assertEquals("bus", vehicleSubtype.getVehicleType());
//    }
//
//    @Test
//    public void read(){
//        createVehicleType();
//        List<VehicleType> types = session
//                .createCriteria(VehicleSubtype.class)
//                .list();
//
//        Assert.assertTrue(types.size()>0);
//    }
}

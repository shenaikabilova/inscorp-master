package kabilova.tu.inscorp.daoimp.test.db;

import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.vehicle.Vehicle;
import org.hibernate.Session;
import org.junit.*;

/**
 * Created by ShenaiKabilova
 */
public class VehicleDaoImplTest {
//    private static Session session;
//    private static Vehicle vehicle = DataTest.getVehicleTest();
//
//    @BeforeClass
//    public static void beforeClass(){
//        session = HibernateUtilTest.getSessionFactory().openSession();
//        session.beginTransaction();
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        session.clear();
//        HibernateUtilTest.shutdown();
//    }
//
//    @Before
//    public void prepareData() {
//        session.save(DataTest.getInsurerTest());
//        session.save(DataTest.getInsuredTest());
//        session.getTransaction().commit();
//    }
//
//    @After
//    public void after() {
//        session.flush();
//    }
//
//    @Test
//    public void createVehicle() {
//        session.save(vehicle);
//        session.getTransaction().commit();
//
//        Assert.assertEquals(1, vehicle.getInsured().getId());
//    }
}

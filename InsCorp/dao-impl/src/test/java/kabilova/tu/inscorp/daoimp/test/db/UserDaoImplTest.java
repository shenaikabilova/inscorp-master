package kabilova.tu.inscorp.daoimp.test.db;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.*;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserDaoImplTest {
//    private static Session session;
//    private static Insurer insurer = DataTest.getInsurerTest();
//    private static Insured insured = DataTest.getInsuredTest();
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
//    public void createUserTest() {
//        session.save(insurer);
//        session.save(insured);
//        session.getTransaction().commit();
//
//        Assert.assertEquals(1, insurer.getId());
//        Assert.assertEquals(2, insured.getId());
//    }
//
////
//    @Test
//    public void updateInsurerTest() {
//        createUserTest();
//        insurer.setFirstName("insurer");
//        session.update(insurer);
//
//        Assert.assertEquals(1, insurer.getId());
//        Assert.assertEquals("insurer", insurer.getFirstName());
//    }
//
//    @Test
//    public void deleteUserTest() {
//        createUserTest();
//        session.delete(insurer);
//
//
//        Assert.assertEquals(1, insurer.getId());
//        Assert.assertTrue(insurer.getUsername().equals("username"));
//    }
//
//    @Test
//    public void loadInsurerByUsernameTest(){
//        createUserTest();
//        List<Insurer> loadInsurer = session
//                            .createCriteria(Insurer.class)
//                            .add(Restrictions.like("username", insurer.getUsername()))
//                            .list();
//
//
//        Assert.assertEquals(1, insurer.getId());
//        Assert.assertEquals(insurer.getUsername(), loadInsurer.get(0).getUsername());
//    }
//
//    @Test
//    public void loadUser() {
//        createUserTest();
//        List<User> loadInsurer = session
//                .createCriteria(Insurer.class)
//                .add(Restrictions.eq("username", "username"))
//                .add(Restrictions.eq("password", "password"))
//                .list();
//
//        Assert.assertEquals(loadInsurer.get(0).getUsername(), insurer.getUsername());
//    }
//

}

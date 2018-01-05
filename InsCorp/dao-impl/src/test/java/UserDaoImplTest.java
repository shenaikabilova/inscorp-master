import kabilova.tu.inscorp.bl.mail.daoimp.test.db.HibernateUtilTest;
import kabilova.tu.inscorp.model.user.Insurer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ShenaiKabilova
 */
public class UserDaoImplTest {
    private Session session;

    private Insurer getInsurer() {
        return new Insurer(1234, "ins1", "ins1", "ins1", "insUsername", "indPass", "123111", "mail@mail.vom");
    }

    @Before
    public void before() {
        session = HibernateUtilTest.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Test
    public void createInsurerTest() {
        Insurer insurer = getInsurer();
        session.save(insurer);
//        session.getTransaction().commit();

        Assert.assertEquals(1, insurer.getId());
    }

    @Test
    public void updateInsurerTest() {
        Insurer insurer = getInsurer();

        insurer.setFirstName("insurer");
        session.update(insurer);
        session.getTransaction().commit();
//        Assert.assertEquals(1, insurer.getId());
        Assert.assertEquals("insurer", insurer.getFirstName());
    }

    @Test
    public void deleteUserTest() {
        Insurer insurer = getInsurer();
        session.delete(insurer);

        Assert.assertTrue(insurer.getUsername().equals("insurer"));
    }

    @Test
    public void loadInsurerTest(){
        Insurer insurer = getInsurer();

        List<Insurer> loadInsurer = session
                .createCriteria(Insurer.class)
                .add(Restrictions.like("username", insurer.getUsername()))
                .list();

        Assert.assertEquals(insurer.getUsername(), loadInsurer.get(0).getUsername());
    }
}

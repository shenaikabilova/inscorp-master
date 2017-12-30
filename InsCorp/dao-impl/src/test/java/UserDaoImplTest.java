import kabilova.tu.inscorp.dao.UserDao;
import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.model.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.net.URL;

/**
 * Created by ShenaiKabilova
 */
public class UserDaoImplTest {
    private SessionFactory sessionFactory;
    private Session session;
    private UserDao dao;

    private SessionFactory createSessionFactory() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(User.class)
                     .addAnnotatedClass(Admin.class)
                     .addAnnotatedClass(Insurer.class)
                     .addAnnotatedClass(Insured.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("test.db.rebuildSchema","true");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testmemdb;ifexists=false");
        configuration.setProperty("hibernate.connection.username", "INSCORP");
        configuration.setProperty("hibernate.connection.password", "INSCORP");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    private Insurer getInsurer() {
        return new Insurer(1234, "ins1", "ins1", "ins1", "insUsername", "indPass", "123", "mail@mail.vom");
    }

    @Before
    public void before() {
        sessionFactory = createSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
    }

    @Test
    public void createInsurerTest() {
        Insurer insurer = getInsurer();
        session.save(insurer);
        Assert.assertEquals(insurer.getId(), dao.readInsurers().get(0).getId());
    }
}

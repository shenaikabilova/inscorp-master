import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by ShenaiKabilova
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Configuration cfg;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            cfg = makeConfig();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    private static Configuration makeConfig() {
        return new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
    }

    public static void shutdown() {
        if(sessionFactory != null && !sessionFactory.isClosed()){
            sessionFactory.close();
            sessionFactory = null;
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            serviceRegistry = null;
        }
    }
}

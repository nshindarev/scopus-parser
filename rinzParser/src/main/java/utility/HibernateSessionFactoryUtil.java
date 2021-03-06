package utility;

import database.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Publication.class);
                configuration.addAnnotatedClass(Cluster.class);
                configuration.addAnnotatedClass(Link.class);
                configuration.addAnnotatedClass(Keyword.class);
                configuration.addAnnotatedClass(AuthorToAuthor.class);
                configuration.addAnnotatedClass(Affiliation.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception!!" + e);
            }
        }
        return sessionFactory;
    }
}

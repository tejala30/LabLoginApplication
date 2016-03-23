package com.prgmming;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by tethippe on 3/22/2016.
 */
public class HibernateUtilities {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            System.err.println("Configurationon object is " + configuration);

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            System.err.println("service registry is " + serviceRegistry);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.err.println("session factory is " + sessionFactory);

        } catch (HibernateException exception){
            exception.printStackTrace(System.err);
            System.out.println("problem creating session factory");
//            System.exit(1);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

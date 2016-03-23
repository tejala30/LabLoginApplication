package com.prgmming;

import org.hibernate.Session;

/**
 * Created by tethippe on 3/22/2016.
 */
public class Program {
    public static void main(String[] args) {

        System.out.println("HELLO!!");

        Session session = HibernateUtilities.getSessionFactory().openSession();

        UserEntity user = new UserEntity();
        user.setUsername("Joe");
        user.setPassword("Joe");
        session.save(user);

        session.getTransaction();
        session.beginTransaction().commit();


        session.close();

        HibernateUtilities.getSessionFactory().close();
    }
}

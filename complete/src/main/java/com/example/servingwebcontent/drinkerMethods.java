package com.example.servingwebcontent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class drinkerMethods {
    SessionFactory sessionFactory;

    public drinkerMethods() {

    }

    public String getDrinkerNames() {
        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.toString());
            // handle the exception
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<drinkers> drinkers;

        Query query = session.createQuery("select * from drinkers", drinkers.class);
        drinkers = query.list();

        session.getTransaction().commit();
        session.close();
        for(drinkers drinker : drinkers) {
            System.out.println(drinker.toString());
        }

        return drinkers.get(0).lastName;
    }
}

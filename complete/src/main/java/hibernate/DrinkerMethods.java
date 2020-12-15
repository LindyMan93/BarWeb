package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DrinkerMethods {
    SessionFactory sessionFactory;

    public DrinkerMethods() {

    }

    public String getDrinkerNames() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Drinkers> drinkers;

        drinkers = session.createQuery("from Drinkers").list();

        session.getTransaction().commit();
        session.close();
        for(Drinkers drinker : drinkers) {
            System.out.println(drinker.toString());
        }

        return drinkers.get(0).lastName;
    }
}

package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DrinkerMethods {
    SessionFactory sessionFactory;

    public DrinkerMethods() {

    }

    public List<Drinkers> getDrinkers() {
        Session session = BarDAO.openCurrentSession();
        return session.createQuery("from Drinkers").list();
    }

    public boolean addDrinker(String firstName, String lastName) {

        Drinkers drinker = new Drinkers();
        drinker.setFirstName(firstName);
        drinker.setLastName(lastName);
        drinker.setCreateDate(BarDAO.getCurrentSqlDate());

        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }

        session.save("Drinkers",drinker);
        trans.commit();
        System.out.println(drinker.toString());
        return true;

    }

    public String getDrinkerNameById(int id) {
        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }
        Drinkers drinker = session.get(hibernate.Drinkers.class, id);
        trans.commit();
        System.out.println(drinker.toString());
        return drinker.getFirstName() + " " + drinker.getLastName();
    }

    public boolean removeDrinkerById(int id) {
        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }
        Drinkers drinker = session.get(hibernate.Drinkers.class, id);

        session.remove(drinker);

        trans.commit();
        System.out.println(drinker.toString());
        return true;
    }
}

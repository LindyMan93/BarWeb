package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerMethods {
    public BeerMethods() {

    }

    public List<Beers> getBeers() {
        Session session = BarDAO.openCurrentSession();
        return session.createQuery("from Beers").list();
    }

    public Map<String, Integer> getNumberOfBeersPerDrinker() {
        List<Beers> allBeers = getBeers();
        HashMap<String, Integer> beerMap = new HashMap<>();
        DrinkerMethods drinkerMethods = new DrinkerMethods();
        for (Beers beer : allBeers) {
            String drinkerName = drinkerMethods.getDrinkerNameById(beer.userId);
            Integer count = beerMap.getOrDefault(drinkerName, 0);
            beerMap.put(drinkerName, count + 1);
        }
        return beerMap;
    }

    public boolean addBeer(int userId) {

        Beers beer = new Beers();
        beer.setUserId(userId);
        beer.setDateDrank(BarDAO.getCurrentSqlDate());

        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }

        session.save("Beers",beer);
        trans.commit();
        System.out.println(beer.toString());
        return true;

    }

    public boolean removeBeerById(int id) {
        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }
        Beers beer = session.get(hibernate.Beers.class, id);

        session.remove(beer);

        trans.commit();
        System.out.println(beer.toString());
        return true;
    }
}

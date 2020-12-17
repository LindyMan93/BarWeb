package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public int getNumberOfBeersPerDrinker(int drinkerId) {
        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }
        Query query = session.createQuery("select count(*) from Beers where userId = :drinkerId");
        query.setParameter("drinkerId", drinkerId);
        Long longCount = (Long) query.getSingleResult();
        int count = longCount.intValue();
        trans.commit();
        return count;
    }

    public Map<String, Integer> getNumberOfBeersEachDrinker() {
        HashMap<String, Integer> beerMap = new HashMap<>();
        DrinkerMethods drinkerMethods = new DrinkerMethods();
        List<Drinkers> drinkers = drinkerMethods.getDrinkers();
        for (Drinkers drinker : drinkers) {
            Integer count = getNumberOfBeersPerDrinker(drinker.getUserId());
            String drinkerFullName = drinker.getFirstName() + " " + drinker.getLastName();
            beerMap.put(drinkerFullName, count);
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

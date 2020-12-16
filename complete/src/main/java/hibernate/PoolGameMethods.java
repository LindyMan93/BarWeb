package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PoolGameMethods {
    public PoolGameMethods() {

    }

    public List<PoolGames> getPoolGames() {
        Session session = BarDAO.openCurrentSession();
        return session.createQuery("from PoolGames").list();
    }

    public boolean addPoolGame(int shooterOne, int shooterTwo, int winner) {

        PoolGames game = new PoolGames();
        game.setShooterOne(shooterOne);
        game.setShooterTwo(shooterTwo);
        game.setWinner(winner);
        game.setGameDate(BarDAO.getCurrentSqlDate());

        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }

        session.save("PoolGames",game);
        trans.commit();
        System.out.println(game.toString());
        return true;

    }

    public boolean removeGameById(int id) {
        Session session = BarDAO.openCurrentSession();
        Transaction trans = session.getTransaction();

        if ( trans == null) {
            trans = session.beginTransaction();
        } else {
            trans.begin();
        }
        PoolGames game = session.get(hibernate.PoolGames.class, id);

        session.remove(game);

        trans.commit();
        System.out.println(game.toString());
        return true;
    }
}

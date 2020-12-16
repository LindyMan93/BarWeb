package hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PoolGames")
public class PoolGames {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int gameId;

    @Column(name = "shooterOne")
    int shooterOne;

    @Column(name = "shooterTwo")
    int shooterTwo;

    @Column(name = "winner")
    int winner;

    @Column(name = "gameDate")
    Date gameDate;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getShooterOne() {
        return shooterOne;
    }

    public void setShooterOne(int shooterOne) {
        this.shooterOne = shooterOne;
    }

    public int getShooterTwo() {
        return shooterTwo;
    }

    public void setShooterTwo(int shooterTwo) {
        this.shooterTwo = shooterTwo;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    @Override
    public String toString() {
        return "poolGames{" +
                "gameId=" + gameId +
                ", shooterOne=" + shooterOne +
                ", shooterTwo=" + shooterTwo +
                ", winner=" + winner +
                ", gameDate=" + gameDate +
                '}';
    }
}

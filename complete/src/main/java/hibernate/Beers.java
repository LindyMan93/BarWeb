package hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Beers")
public class Beers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int beerId;

    @Column(name = "userId")
    int userId;

    @Column(name = "dateDrank")
    Date dateDrank;

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateDrank() {
        return dateDrank;
    }

    public void setDateDrank(Date dateDrank) {
        this.dateDrank = dateDrank;
    }

    @Override
    public String toString() {
        return "beers{" +
                "beerId=" + beerId +
                ", userId=" + userId +
                ", dateDrank=" + dateDrank +
                '}';
    }
}

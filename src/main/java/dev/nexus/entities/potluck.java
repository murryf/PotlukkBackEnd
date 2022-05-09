package dev.nexus.entities;


import javax.persistence.*;

@Entity
@Table(name = "potluck")
public class potluck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "potluck_name")
    private String potluckName;

    @Column(name = "potluck_date")
    private double potluckDate;

    @Column(name = "creator_id")
    private int creatorId;

    public potluck() {
    }

    public potluck(int id, String potluckName, double potluckDate, int creatorId) {
        this.id = id;
        this.potluckName = potluckName;
        this.potluckDate = potluckDate;
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPotluckName() {
        return potluckName;
    }

    public void setPotluckName(String potluckName) {
        this.potluckName = potluckName;
    }

    public double getPotluckDate() {
        return potluckDate;
    }

    public void setPotluckDate(double potluckDate) {
        this.potluckDate = potluckDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "potluck{" +
                "id=" + id +
                ", potluckName='" + potluckName + '\'' +
                ", potluckDate=" + potluckDate +
                ", creatorId=" + creatorId +
                '}';
    }


}

package dev.nexus.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "potlucks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Potluck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "potluck_id")
    private int id;

    @Column(name = "potluck_name")
    private String potluckName;

    @Column(name = "potluck_date")
    private double potluckDate;

    @Column(name = "creator_id")
    private int creator;

    public void setPotluckDate(double potluckDate) {
        this.potluckDate = potluckDate;
    }
}

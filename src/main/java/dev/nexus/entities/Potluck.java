package dev.nexus.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "potlucks")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Potluck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "potluck_name")
    private String potluckName;

    @Column(name = "potluck_date")
    private double potluckDate;

    @Column(name = "creator_id")
    private int  creator;



}

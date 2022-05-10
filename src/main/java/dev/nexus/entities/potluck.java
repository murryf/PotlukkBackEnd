package dev.nexus.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "potluck")
@NoArgsConstructor
@AllArgsConstructor
@ToString
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



}

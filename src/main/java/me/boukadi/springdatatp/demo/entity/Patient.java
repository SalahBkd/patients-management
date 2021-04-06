package me.boukadi.springdatatp.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="patient")
@Data @AllArgsConstructor @ToString @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "date_naissance")
    private Date dateNaisssance;
    @Column(name = "score")
    private int score;
    @Column(name = "malade")
    private boolean malade;
}

package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2018-02-12.
 */
@Data
@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "portfolio")
    private List<Investment> investments = new ArrayList<>();
}

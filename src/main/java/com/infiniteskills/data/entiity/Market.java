package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by USER on 2018-02-06.
 */
@Data
@Entity
@Table(name = "MARKET")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARK_ID")
    private Long marketId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "CURRENCY_NAME", referencedColumnName = "NAME"),
            @JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "COUNTRY_NAME")
    })
    private Currency currency;

    @Column(name = "MARKET_NAME")
    private String marketName;

}

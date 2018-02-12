package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by USER on 2018-02-12.
 */
@Data
@Entity
@Table(name = "STOCK")
public class Stock extends Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private Long stockId;

    @Column(name = "SHARE_PRICE")
    private BigDecimal sharePrice;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;
}

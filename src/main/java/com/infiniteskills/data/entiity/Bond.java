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
@DiscriminatorValue("BND")
//@Table(name = "BOND")
public class Bond extends Investment {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOND_ID")
    private Long bondId;*/

    @Column(name = "VALUE")
    private BigDecimal value;

    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "MATURITY_DATE")
    private Date maturityDate;
}

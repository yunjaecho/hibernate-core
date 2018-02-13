package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 2018-02-12.
 */
@Data
@Entity
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "INVESTMENT_TYPE")
@Table(name = "INVESTMENT")
public abstract class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generate")
    @TableGenerator(table = "ifinances_keys",
            pkColumnName = "pk_name",
            valueColumnName = "pk_value",
            name = "key_generate")
    @Column(name = "INVESTMENT_ID")
    private Long investmentId;


    @JoinColumn(name = "PORTFOLIO_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Portfolio portfolio;


    @Column(name = "NAME")
    protected String name;

    @Column(name = "ISSUER")
    protected String issurer;

    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;
}

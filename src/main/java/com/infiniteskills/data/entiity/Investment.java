package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by USER on 2018-02-12.
 */
@Data
@MappedSuperclass
public abstract class Investment {
    @Column(name = "NAME")
    protected String name;

    @Column(name = "ISSUER")
    protected String issurer;

    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;
}

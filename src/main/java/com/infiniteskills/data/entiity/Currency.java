package com.infiniteskills.data.entiity;

import com.infiniteskills.data.entiity.ids.CurrencyId;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by USER on 2018-02-06.
 */
@Data
@Entity

@IdClass(CurrencyId.class)
public class Currency {
    @Id
    @Column(name = "NAME")
    private String name;

    @Id
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "SYMBOL")
    private String symbol;
}

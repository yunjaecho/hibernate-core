package com.infiniteskills.data.entiity.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by USER on 2018-02-06.
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("serial")
public class CurrencyId implements Serializable {

    public CurrencyId() {}

    private String name;

    private String countryName;
}

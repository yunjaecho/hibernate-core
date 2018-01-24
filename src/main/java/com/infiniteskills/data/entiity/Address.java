package com.infiniteskills.data.entiity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by USER on 2018-01-23.
 */
@Data
@NoArgsConstructor
@Embeddable
//@Entity
//@Table(name = "ADRESS")
public class Address {
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;

    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;


}

package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

/**
 * Created by USER on 2018-01-23.
 */
@Data
@Entity
@Table(name = "BANK")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    private Long bankId;

    @Column(name = "NAME")
    private String name;

    @Embedded
    private Address address = new Address();

    @Column(name = "IS_INTERNATIONAL")
    private boolean international;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY" , updatable = false)
    private String createdBy;

    @ElementCollection
    @CollectionTable(name = "BANK_CONTACT", joinColumns =@JoinColumn(name = "BANK_ID"))
    @MapKeyColumn(name = "POSITION_TYPE")
    @Column(name = "NAME")
    private Map<String, String> contracts = new HashMap<String, String>();


}

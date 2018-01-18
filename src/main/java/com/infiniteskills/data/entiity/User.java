package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 2018-01-18.
 */

@Data
@Entity
@Table(name = "finances_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdateDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdateBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;
}

package com.infiniteskills.data.entiity;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.*;

/**
 * Created by USER on 2018-01-18.
 */

@Data
@Entity
@Table(name = "FINANCES_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Account> accounts = new HashSet<Account>();

//    @OneToOne(mappedBy = "user")
//    private Credential credential;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private Credential credential;


    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @ElementCollection
    @CollectionTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2")) })
    private List<Address> addresses = new ArrayList<Address>();

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Formula("lower(datediff(curdate(), birth_date)/365)")
    private int age;

    @Override
    public String toString() {
        return "\nUser{" +
                "\nuserId=" + userId +
                "\n, firstName='" + firstName + '\'' +
                "\n, lastName='" + lastName + '\'' +
                "\n, birthDate=" + birthDate +
                "\n, emailAddress='" + emailAddress + '\'' +
                "\n, lastUpdateDate=" + lastUpdatedDate +
                "\n, lastUpdateBy='" + lastUpdatedBy + '\'' +
                "\n, createdDate=" + createdDate +
                "\n, createdBy='" + createdBy + '\'' +
                "\n, age=" + age +
                "\n}";
    }
}

package com.infiniteskills.data.entiity;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToOne(mappedBy = "user")
    private Credential credential;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @ElementCollection
    @CollectionTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @AttributeOverrides({@AttributeOverride(name="addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name="addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))})
    private List<Address> address = new ArrayList<Address>();

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdateDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdateBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY" , updatable = false)
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
                "\n, lastUpdateDate=" + lastUpdateDate +
                "\n, lastUpdateBy='" + lastUpdateBy + '\'' +
                "\n, createdDate=" + createdDate +
                "\n, createdBy='" + createdBy + '\'' +
                "\n, age=" + age +
                "\n}";
    }
}

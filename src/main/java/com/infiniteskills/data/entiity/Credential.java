package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CREDENTIAL")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CREDENTIAL_ID")
    public Long credentialId;

//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="USER_ID")
//    public User user;

    @OneToOne(mappedBy = "credential")
    private User user;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

}

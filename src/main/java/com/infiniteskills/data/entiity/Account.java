package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Data
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
        @NamedQuery(name = "Account.largeDeposits", query = "select distinct t.account from Transaction t where t.amount > 20 and lower(t.transactionType) = 'deposit' ")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    // 조인시 지연실행 (fetch = FetchType.LAZY) 값을 가져올때 그때 조회
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ACCOUNT", joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> users = new HashSet<User>();

    //private Bank bank;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<Transaction>();

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountTpe;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

    @Column(name = "OPEN_DATE")
    @Temporal(TemporalType.DATE)
    private Date openDate;

    @Column(name = "CLOSE_DATE")
    @Temporal(TemporalType.DATE)
    private Date closeDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}

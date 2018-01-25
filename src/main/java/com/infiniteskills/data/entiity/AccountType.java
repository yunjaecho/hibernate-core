package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
//@Entity
//@Table(name = "ACCOUNT_TYPE")
public class AccountType {
    private Long accountTypeId;

    private String name;

    private Date lastUpdatedDate;

    private String lastUpdatedBy;

    private Date createdDate;

    private String createdBy;


}

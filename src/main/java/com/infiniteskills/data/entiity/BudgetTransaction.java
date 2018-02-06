package com.infiniteskills.data.entiity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
//@Entity
//@Table(name = "BUDGET")
public class BudgetTransaction {

    private Long transactionId;
    private Long budgetId;
}

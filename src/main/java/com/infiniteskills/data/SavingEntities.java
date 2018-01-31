package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Account;
import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by USER on 2018-01-29.
 */
public class SavingEntities {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();

        Account account = createNewAccount();

        Transaction tran1 = createNewBeltPurchase(account);
        Transaction tran2 = createShoePurchase(account);
        account.getTransactions().add(tran1);
        account.getTransactions().add(tran2);

        System.out.println(session.contains(account));
        System.out.println(session.contains(tran1));
        System.out.println(session.contains(tran2));
        try {
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.save(account);

            System.out.println(session.contains(account));
            System.out.println(session.contains(tran1));
            System.out.println(session.contains(tran2));

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

    private static Transaction createShoePurchase(Account account) {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Transaction createNewBeltPurchase(Account account) {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal(50.00));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        return account;
    }


}

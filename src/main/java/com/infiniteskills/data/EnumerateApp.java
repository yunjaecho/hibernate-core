package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Account;
import com.infiniteskills.data.entiity.AccountType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by USER on 2018-02-12.
 */
public class EnumerateApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Account account = createAccount();
            account.setAccountTpe(AccountType.SVINGS);
            session.save(account);
            tx.commit();

            Account dbAccount = (Account)session.get(Account.class, account.getAccountId());
            System.out.println(dbAccount.getName());
            System.out.println(dbAccount.getAccountTpe());

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static Account createAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }
}

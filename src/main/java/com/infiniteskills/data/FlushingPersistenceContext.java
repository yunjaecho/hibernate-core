package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bank;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by USER on 2018-01-31.
 */
public class FlushingPersistenceContext {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try {
            Bank bank = (Bank) session.get(Bank.class, 1L);
            bank.setName("Something Different");
            System.out.println("Calling Flush");
            session.flush();

            bank.getAddress().setAddressLine1("Another Address Line");
            System.out.println("Calling Commit");
            transaction.commit();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

    private static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Federal Trust");
        bank.getAddress().setAddressLine1("33 Wall Street");
        bank.getAddress().setAddressLine2("Suit 302");
        bank.getAddress().setCity("New York");
        bank.getAddress().setState("NY");
        bank.getAddress().setZipCode("27945");
        bank.setCreatedBy("Kevin Bowersox");
        bank.setCreatedDate(new Date());
        bank.setLastUpdateBy("Kevin Bowersox");
        bank.setLastUpdatedDate(new Date());
        bank.setInternational(false);
        return bank;
    }
}

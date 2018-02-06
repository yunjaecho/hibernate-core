package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Account;
import com.infiniteskills.data.entiity.Bank;
import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by USER on 2018-01-31.
 */
public class SaveOrUpdateApp {
    public static void main(String[] args) {


        try {
            Session session =  HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction transaction = session.beginTransaction();

            Bank detacheBank = (Bank) session.get(Bank.class, 1L);
            transaction.commit();
            session.close();

            Bank trasient = createBank();

            Session session2 = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction transaction2 = session2.beginTransaction();

            session2.saveOrUpdate(trasient);
            session2.saveOrUpdate(detacheBank);
            detacheBank.setName("Test Bank 2");

            transaction2.commit();
            session2.close();

            System.out.println("End ..............");

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
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
        bank.getContracts().put("MANAGE", "joe");
        bank.getContracts().put("TELLER", "Merry");
        return bank;
    }
}

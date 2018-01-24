package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bank;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by USER on 2018-01-23.
 */
public class AppBank {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

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
//            bank.getContracts().add("Joe");
//            bank.getContracts().add("Merry");
            bank.getContracts().put("MANAGE", "joe");
            bank.getContracts().put("TELLER", "Merry");

            session.save(bank);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

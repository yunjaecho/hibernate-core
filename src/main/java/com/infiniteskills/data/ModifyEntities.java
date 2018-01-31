package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bank;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by USER on 2018-01-29.
 */
public class ModifyEntities {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();


        try {
            org.hibernate.Transaction transaction = session.beginTransaction();
            Bank bank = (Bank)session.get(Bank.class, 1L);

            bank.setName("New Hop Bank");
            bank.setLastUpdateBy("Kevin Bowersox");
            bank.setLastUpdatedDate(new Date());

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

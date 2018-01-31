package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bank;
import org.hibernate.Session;

/**
 * Created by USER on 2018-01-29.
 */
public class RetrievingEntities {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();


        try {
            org.hibernate.Transaction transaction = session.beginTransaction();
            Bank bank = (Bank)session.load(Bank.class, 243231L);
            System.out.println("Method Executed");

            System.out.println(bank.getName());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bank;
import org.hibernate.Session;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by USER on 2018-01-29.
 */
public class ReAttachDetache {
    public static void main(String[] args) {


        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction transaction = session.beginTransaction();
            Bank bank = (Bank) session.get(Bank.class, 1L);
            transaction.commit();
            session.close();


            Session session2 = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction transaction2 = session2.beginTransaction();

            System.out.println(session2.contains(bank));
            session2.update(bank);
            bank.setName("Test Bank");
            System.out.println("Method Invoked");
            System.out.println(session2.contains(bank));

            transaction2.commit();
            session2.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}

package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Created by USER on 2018-02-19.
 */
public class HqlApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            /*Query query = session.createQuery("select t from Transaction t where t.amount > :amount");
            query.setParameter("amount", new BigDecimal(scanner.next()));*/

            Query query = session.getNamedQuery("Account.largeDeposits");

            List<Transaction> transactions = query.list();

            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch(Exception ex) {

        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }

    }
}

package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by USER on 2018-02-20.
 */
public class HibernateCriteriaApp {
    public static void main(String[] args) {
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();


            Criteria criteria = session.createCriteria(Transaction.class);
            criteria.addOrder(Order.desc("title"));
            List<Transaction> transactions = criteria.list();

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

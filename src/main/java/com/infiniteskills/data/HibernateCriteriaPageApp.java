package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by USER on 2018-02-20.
 */
public class HibernateCriteriaPageApp {
    public static void main(String[] args) {
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        int pageNumber = 2;
        int pageSize   = 4;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            List<Transaction> transactions = session.createCriteria(Transaction.class)
                    .addOrder(Order.desc("title"))
                    .setFirstResult((pageNumber -1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();

            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (factory != null) factory.close();
        }
    }
}

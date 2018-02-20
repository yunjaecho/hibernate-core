package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;
import org.hibernate.Criteria;
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
public class HibernateCriteriaRestrictApp {
    public static void main(String[] args) {
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Criterion criterion1 = Restrictions.le("amount", new BigDecimal("20.00"));
            Criterion criterion2 = Restrictions.eq("transactionType", "Withdrawl");


            List<Transaction> transactions = session.createCriteria(Transaction.class)
                    .add(Restrictions.and(criterion1, criterion2))
                    .addOrder(Order.desc("title"))
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

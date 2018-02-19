package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by USER on 2018-02-19.
 */
public class JpqlApplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();
            tx = em.getTransaction();

            //Query query = em.createQuery("from Transaction t order by t.title");
            TypedQuery<Transaction> query = em.createQuery("from Transaction t order by t.title", Transaction.class);
            List<Transaction> transactions = query.getResultList();

            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch(Exception ex) {

        } finally {
            if (em != null) em.close();
            if (factory != null) factory.close();
        }
    }
}

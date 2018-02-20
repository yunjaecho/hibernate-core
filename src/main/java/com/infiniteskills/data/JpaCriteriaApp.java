package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by USER on 2018-02-20.
 */
public class JpaCriteriaApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();
            tx = em.getTransaction();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Transaction> criteriaQuery = builder.createQuery(Transaction.class);
            Root<Transaction> root = criteriaQuery.from(Transaction.class);
            criteriaQuery.select(root);

            TypedQuery<Transaction> query = em.createQuery(criteriaQuery);

            List<Transaction> transactions = query.getResultList();

            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            //tx.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (factory != null) factory.close();
        }
    }
}

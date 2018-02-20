package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by USER on 2018-02-20.
 */
public class JpaCriteriaRestrictApp {
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
            Path<BigDecimal> amountPath = root.get("amount");
            Path<String> transactionTypePath = root.get("transactionType");


            criteriaQuery.select(root)
                    .where(builder.and(builder.le(amountPath, new BigDecimal("20.00")),
                            builder.equal(transactionTypePath, "Withdrawl")));

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

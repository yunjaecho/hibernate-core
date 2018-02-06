package com.infiniteskills.data;


import com.infiniteskills.data.entiity.Bank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by USER on 2018-02-06.
 */
public class JPAConfigApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("infinite-finances");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Bank bank = createBank();

        em.persist(bank);

        tx.commit();

        em.close();
        emf.close();
    }

    private static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Federal Trust");
        bank.getAddress().setAddressLine1("33 Wall Street");
        bank.getAddress().setAddressLine2("Suit 302");
        bank.getAddress().setCity("New York");
        bank.getAddress().setState("NY");
        bank.getAddress().setZipCode("27945");
        bank.setCreatedBy("Kevin Bowersox");
        bank.setCreatedDate(new Date());
        bank.setLastUpdateBy("Kevin Bowersox");
        bank.setLastUpdatedDate(new Date());
        bank.setInternational(false);
        return bank;
    }
}

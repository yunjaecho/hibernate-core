package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Currency;
import com.infiniteskills.data.entiity.Market;
import com.infiniteskills.data.entiity.ids.CurrencyId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by USER on 2018-02-06.
 */
public class CompoundPKApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Session session2 = null;
        Transaction tx = null;
        Transaction tx2 = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Currency currency = new Currency();
            currency.setCountryName("United Kingdom");
            currency.setName("Pound");
            currency.setSymbol("Pound Sign");

            Market market = new Market();
            market.setMarketName("London Stock Exchage");
            market.setCurrency(currency);

            session.persist(market);
            tx.commit();

            Market dbMarket = session.get(Market.class,market.getMarketId());
            System.out.println(dbMarket.getCurrency().getName());

            /*session2 = sessionFactory.openSession();
            tx2 = session2.beginTransaction();

            Currency dbCurrency = session2.get(Currency.class, new CurrencyId("Dollar", "United Status"));

            System.out.println(dbCurrency.getName());
            tx2.commit();*/



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            //session2.close();
            sessionFactory.close();
        }
    }
}

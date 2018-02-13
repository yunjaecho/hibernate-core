package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Bond;
import com.infiniteskills.data.entiity.Investment;
import com.infiniteskills.data.entiity.Portfolio;
import com.infiniteskills.data.entiity.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by USER on 2018-02-12.
 */
public class TablePerInheritanceApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Portfolio portfolio = new Portfolio();
            portfolio.setName("First Investment");

            Stock stock = createStock();
            stock.setPortfolio(portfolio);

            Bond bond = createBond();
            bond.setPortfolio(portfolio);

            portfolio.getInvestments().add(stock);
            portfolio.getInvestments().add(bond);

            session.save(stock);
            session.save(bond);
            tx.commit();

            Portfolio dbPortfolio = (Portfolio)session.get(Portfolio.class, portfolio.getPortfolioId());
            session.refresh(dbPortfolio);

            for(Investment investment :  dbPortfolio.getInvestments()) {
                System.out.println(investment.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static Bond createBond() {
        Bond bond = new Bond();
        bond.setInterestRate(new BigDecimal("123.22"));
        bond.setIssurer("JP Morgan Chase");
        bond.setMaturityDate(new Date());
        bond.setPurchaseDate(new Date());
        bond.setName("Long Term Bond Purchases");
        bond.setValue(new BigDecimal("10.22"));
        return bond;
    }

    private static Stock createStock(){
        Stock stock = new Stock();
        stock.setIssurer("Allen Edmonds");
        stock.setName("Private American Stock Purchases");
        stock.setPurchaseDate(new Date());
        stock.setQuantity(new BigDecimal("1922"));
        stock.setSharePrice(new BigDecimal("100.00"));
        return stock;
    }
}

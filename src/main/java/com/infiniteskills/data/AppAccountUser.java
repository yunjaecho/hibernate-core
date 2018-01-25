package com.infiniteskills.data;


import com.infiniteskills.data.entiity.Account;
import com.infiniteskills.data.entiity.Address;
import com.infiniteskills.data.entiity.Credential;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AccessType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 2018-01-25.
 */
public class AppAccountUser {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            Account account = createNewAccount();
            Account account2 = createNewAccount();
            User user = createUser();
            User user2 = createUser();

            account.getUsers().add(user);
            account.getUsers().add(user2);
            user.getAccounts().add(account);
            user2.getAccounts().add(account);

            account2.getUsers().add(user);
            account2.getUsers().add(user2);
            user.getAccounts().add(account2);
            user2.getAccounts().add(account2);


            session.save(user);
            session.save(user2);

            transaction.commit();

            User dbUser = (User) session.get(User.class, user.getUserId());
            System.out.println(dbUser.getAccounts().iterator().next().getName());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        user.setCredential(createCredential(user));
        user.setEmailAddress("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedDate(new Date());
        return user;
    }

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUsername("test_username");
        credential.setPassword("test_password");
        return credential;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("101 Address Line");
        address.setAddressLine2("102 Address Line");
        address.setCity("New York");
        address.setState("PA");
        address.setZipCode("10000");
        address.setAddressType("PRIMARY");
        return address;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }

}

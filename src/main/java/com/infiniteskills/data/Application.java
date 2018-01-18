package com.infiniteskills.data;

import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by USER on 2018-01-18.
 */
public class Application {
    public static void main(String[] args) {

        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        AccountType accountType = new AccountType();
//        accountType.setName("Checking");
//        accountType.setCreatedDate(new Date());
//        accountType.setLastUpdatedUate(new Date());
//        accountType.setCreatedBy("kevinbowersox");
//        accountType.setLastUpdatedBy("kevinbowersox");
//
//        session.save(accountType);
//        session.getTransaction().commit();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385@yahoo.com");
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setLastUpdateBy("kevin");
        user.setLastUpdateDate(new Date());

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}

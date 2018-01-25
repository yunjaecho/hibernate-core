package com.infiniteskills.data;

import com.infiniteskills.data.entiity.TimeTest;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 2018-01-18.
 */
public class Application {
    public static void main(String[] args) {

        Session session =  HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            User user = new User();
            user.setBirthDate(getMyBirthday());
            user.setCreatedBy("kevin");
            user.setCreatedDate(new Date());
            user.setEmailAddress("kmb385@yahoo.com");
            user.setFirstName("Kevin");
            user.setLastName("Bowersox");
            user.setLastUpdatedBy("kevin");
            user.setLastUpdatedDate(new Date());

            session.save(user);
            session.getTransaction().commit();
            session.refresh(user);
            System.out.println(user.toString());

            /*TimeTest test = new TimeTest(new Date());

            session.getTransaction().begin();
            session.save(test);
            session.getTransaction().commit();

            session.refresh(test);
            System.out.println(test.toString());*/

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }


    }


    private static Date getMyBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1984);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DATE, 19);
        return calendar.getTime();
    }
}

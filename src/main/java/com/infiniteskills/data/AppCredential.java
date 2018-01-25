package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Address;
import com.infiniteskills.data.entiity.Credential;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 2018-01-24.
 */
public class AppCredential {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            user.setAge(33);
            user.setBirthDate(getMyBirthday());
            user.setCreatedBy("kevin");
            user.setCreatedDate(new Date());
            user.setEmailAddress("kmb385@yahoo.com");
            user.setFirstName("Kevin");
            user.setLastName("Bowersox");
            user.setLastUpdatedBy("kevin");
            user.setLastUpdatedDate(new Date());

            Credential credential = new Credential();
            credential.setPassword("kevinspassword");
            credential.setUsername("kmb385");

            credential.setUser(user);
            user.setCredential(credential);

            session.save(credential);
            transaction.commit();

            User dbUser = session.get(User.class, credential.getUser().getUserId());
            System.out.println(dbUser.getFirstName());

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }

    private static Date getMyBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1974);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 12);
        return calendar.getTime();
    }
}

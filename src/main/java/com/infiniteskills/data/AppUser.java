package com.infiniteskills.data;

import com.infiniteskills.data.entiity.Address;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 2018-01-23.
 */
public class AppUser {
    public static void main(String[] args) {
        Session session =  HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

            User user = new User();
            Address address  = new Address();
            Address address2 = new Address();
            setAddressFields(address);
            setAddressFields2(address2);
            user.getAddresses().add(address);
            user.getAddresses().add(address2);

            setUserFields(user);

            session.save(user);
            transaction.commit();

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

    private static void setUserFields(User user) {
        user.setAge(22);
        user.setBirthDate(getMyBirthday());
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385@yahoo.com");
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
    }

    private static void setAddressFields(Address address) {
        address.setAddressLine1("Line 1");
        address.setAddressLine2("Line 2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
    }


    private static void setAddressFields2(Address address) {
        address.setAddressLine1("Line 1-2");
        address.setAddressLine2("Line 2-2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
    }
}

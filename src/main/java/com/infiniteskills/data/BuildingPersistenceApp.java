package com.infiniteskills.data;

import com.infiniteskills.data.dao.UserHibernateDao;
import com.infiniteskills.data.dao.interfaces.UserDao;
import com.infiniteskills.data.entiity.Address;
import com.infiniteskills.data.entiity.Credential;
import com.infiniteskills.data.entiity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by USER on 2018-02-13.
 */
public class BuildingPersistenceApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            UserDao dao = new UserHibernateDao();
            dao.setSession(session);

            User user = createUser();
            dao.save(user);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        //user.setCredential(createCredential(user));
        user.setEmailAddress("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedDate(new Date());
        return user;
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

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUsername("test_username");
        credential.setPassword("test_password");
        return credential;
    }
}

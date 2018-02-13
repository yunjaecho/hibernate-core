package com.infiniteskills.data.dao;

import com.infiniteskills.data.dao.interfaces.UserDao;
import com.infiniteskills.data.entiity.User;

import java.util.List;

/**
 * Created by USER on 2018-02-13.
 */
public class UserHibernateDao extends AbstractDao<User, Long> implements UserDao {
    @Override
    public List<User> findByFirstName(String firstName) {
        return null;
    }
}

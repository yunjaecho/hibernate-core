package com.infiniteskills.data.dao.interfaces;

import com.infiniteskills.data.entiity.User;

import java.util.List;

/**
 * Created by USER on 2018-02-13.
 */
public interface UserDao extends Dao<User, Long> {
    public List<User> findByFirstName(String firstName);
}

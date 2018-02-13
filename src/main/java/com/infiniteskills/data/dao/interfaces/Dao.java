package com.infiniteskills.data.dao.interfaces;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by USER on 2018-02-13.
 */
public interface Dao<T, ID> {
    public T findById(ID id);

    public List<T> findAll();

    public T save(T entity);

    public void delete(T entity);

    public void flush();

    public void clear();

    public void setSession(Session session);
}

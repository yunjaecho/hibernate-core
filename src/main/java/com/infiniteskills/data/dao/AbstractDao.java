package com.infiniteskills.data.dao;

import com.infiniteskills.data.HibernateUtil;
import com.infiniteskills.data.dao.interfaces.Dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by USER on 2018-02-13.
 */
public class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {

    private Class<T> persistentClass;
    private Session session;

    public AbstractDao() {
        this.persistentClass = (Class<T>)((ParameterizedType)getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        if (this.session == null) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        return this.session;
    }

    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }

    @Override
    public T findById(ID id) {
        return (T) getSession().load(this.getPersistentClass(), id);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    protected List<T> findByCriteria(Criterion ... criterias) {
        Criteria cri = this.getSession().createCriteria(this.getPersistentClass());

        for (Criterion c : criterias) {
            cri.add(c);
        }
        return (List<T>) cri;
    }

    @Override
    public T save(T entity) {
        this.getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getSession().flush();
    }

    @Override
    public void clear() {
        this.getSession().clear();
    }


}

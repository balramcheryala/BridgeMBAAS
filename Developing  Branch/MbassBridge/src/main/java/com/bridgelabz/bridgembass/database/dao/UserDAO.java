package com.bridgelabz.bridgembass.database.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.bridgelabz.bridgembass.database.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAO.
 */
@Service
public class UserDAO implements GenericDao<User,String> {

    /** The template. */
    @Autowired
    private HibernateTemplate template;

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#load(java.io.Serializable)
     */
    @Override
    public User load(final String id) {
        return template.load(User.class,id);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#get(java.io.Serializable)
     */
    @Override
    public User get(final String id) {
        return template.get(User.class,id);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#getAll()
     */
    @Override
    public List<User> getAll() {
        return template.loadAll(User.class);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#save(java.io.Serializable)
     */
    @Override
    public Serializable save(final User object) {
        return template.save(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#saveOrUpdate(java.io.Serializable)
     */
    @Override
    public void saveOrUpdate(final User object) {
        template.saveOrUpdate(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#delete(java.io.Serializable)
     */
    @Override
    public void delete(final User object) {
        template.delete(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#count()
     */
    @Override
    public Long count() {
        return new Long(template.loadAll(User.class).size());
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#flush()
     */
    @Override
    public void flush() {
    	System.out.println("Write changes to the database");
        template.flush();
    }

}

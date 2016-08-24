package com.bridgelabz.bridgembass.database.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.bridgelabz.bridgembass.database.model.Role;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleDAO.
 */
@Service
public class RoleDAO implements GenericDao<Role,Integer>{

    /** The hibernate template. */
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#load(java.io.Serializable)
     */
    @Override
    public Role load(final Integer id) {
        return hibernateTemplate.load(Role.class,id);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#get(java.io.Serializable)
     */
    @Override
    public Role get(final Integer id) {
        return hibernateTemplate.get(Role.class,id);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#getAll()
     */
    @Override
    public List<Role> getAll() {
        return hibernateTemplate.loadAll(Role.class);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#save(java.io.Serializable)
     */
    @Override
    public Serializable save(final Role object) {
        return hibernateTemplate.save(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#saveOrUpdate(java.io.Serializable)
     */
    @Override
    public void saveOrUpdate(final Role object) {
        hibernateTemplate.saveOrUpdate(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#delete(java.io.Serializable)
     */
    @Override
    public void delete(final Role object) {
        hibernateTemplate.delete(object);
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#count()
     */
    @Override
    public Long count() {
        return new Long(hibernateTemplate.loadAll(Role.class).size());
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.bridgembass.database.dao.GenericDao#flush()
     */
    @Override
    public void flush() {
        hibernateTemplate.flush();
    }
}

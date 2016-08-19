package com.bridgelabz.bridgembass.database.dao;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericDao.
 *
 * @param <T>
 *            the generic type
 * @param <K>
 *            the key type
 */
public interface GenericDao<T extends Serializable, K extends Serializable> {

    /**
	 * Load.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
    public T load(K id);

    /**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
    public T get(K id);

    /**
	 * Gets the all.
	 *
	 * @return the all
	 */
    public List<T> getAll();

    /**
	 * Save.
	 *
	 * @param object
	 *            the object
	 * @return the serializable
	 */
    public Serializable save(T object);

    /**
	 * Save or update.
	 *
	 * @param object
	 *            the object
	 */
    public void saveOrUpdate(T object);

    /**
	 * Delete.
	 *
	 * @param object
	 *            the object
	 */
    public void delete(T object);

    /**
	 * Count.
	 *
	 * @return the long
	 */
    public Long count();

    /**
	 * Flush.
	 */
    void flush();
}
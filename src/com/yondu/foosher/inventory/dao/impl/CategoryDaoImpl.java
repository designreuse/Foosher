/**
 * 
 */
package com.yondu.foosher.inventory.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yondu.foosher.inventory.dao.CategoryDao;
import com.yondu.foosher.inventory.domains.Category;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.inventory.dao.CategoryDao#save(ph.yondu.foosher.inventory.domains.Category)
	 */
	@Override
	@Transactional
	public void save(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.inventory.dao.CategoryDao#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("enabled", true)).list();
	}

}

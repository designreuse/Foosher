/**
 * 
 */
package com.yondu.foosher.cms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yondu.foosher.cms.dao.RoleDao;
import com.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.RoleDao#save(ph.yondu.foosher.cms.domains.Role)
	 */
	@Override
	@Transactional
	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.RoleDao#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Role> list() {
		return sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.eq("enabled", true)).list();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.RoleDao#get(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Role get(Long id) {
		return (Role) sessionFactory.
				getCurrentSession().
				createCriteria(Role.class).
				add(Restrictions.eq("enabled", true)).
				add(Restrictions.eq("id", id)).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.RoleDao#disable(java.lang.Long)
	 */
	@Override
	@Transactional
	public void disable(Long id) {
		String hqlUpdate = "update Role set enabled = :role_enabled where id = :role_id";
		sessionFactory.getCurrentSession().createQuery( hqlUpdate )
		        .setBoolean( "role_enabled", false )
		        .setLong( "role_id", id )
		        .executeUpdate();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.RoleDao#getInitialized(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Role getInitialized(Long id) {
		Role initRole = (Role) sessionFactory.
				getCurrentSession().
				createCriteria(Role.class).
				add(Restrictions.eq("enabled", true)).
				add(Restrictions.eq("id", id)).uniqueResult();
		if(initRole != null){
			Hibernate.initialize(initRole.getUsers());
		}
		return initRole;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Role> list(String column, boolean isAscending, String searchName, String searchCategory) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("enabled", true));
		if(!searchName.isEmpty() && !searchCategory.isEmpty()) criteria.add(Restrictions.like(searchCategory, "%" + searchName + "%"));
		if(isAscending){
			criteria.addOrder(Order.asc(column));
		} else {
			criteria.addOrder(Order.desc(column));
		}
		return criteria.list();
	}

}

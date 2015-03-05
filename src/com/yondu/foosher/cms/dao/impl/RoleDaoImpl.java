/**
 * 
 */
package com.yondu.foosher.cms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
	
	@Override
	@Transactional
	public void save(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Role> list() {
		return sessionFactory.getCurrentSession().createCriteria(Role.class).
				add(Restrictions.eq(Role.ENABLED, true)).list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Role getInitialized(Long id) {
		Role initRole = (Role) sessionFactory.
				getCurrentSession().
				createCriteria(Role.class).
				add(Restrictions.eq(Role.ENABLED, true)).
				add(Restrictions.eq(Role.ID, id)).uniqueResult();
		if(initRole != null){
			Hibernate.initialize(initRole.getUsers());
		}
		return initRole;
	}

	@Override
	@Transactional(readOnly=true)
	public Role get(Long id) {
		return (Role) sessionFactory.
				getCurrentSession().
				createCriteria(Role.class).
				add(Restrictions.eq(Role.ENABLED, true)).
				add(Restrictions.eq(Role.ID, id)).uniqueResult();
	}

	@Override
	@Transactional
	public void disable(Long id) {
		String hqlUpdate = "update Role set enabled = :enabled where id = :id";
		sessionFactory.getCurrentSession().createQuery( hqlUpdate )
		        .setBoolean( Role.ENABLED, false )
		        .setLong( Role.ID, id )
		        .executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Role> list(String column, boolean isAscending, String searchName, String searchCategory) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		if(!searchName.isEmpty() && !searchCategory.isEmpty()) {
			criteria.add(Restrictions.like(searchCategory, "%" + searchName + "%"));
		}
		if(isAscending){
			criteria.addOrder(Order.asc(column));
		} else {
			criteria.addOrder(Order.desc(column));
		}
		criteria.add(Restrictions.eq(Role.ENABLED, true));
		return criteria.list();
	}
	
	@Transactional(readOnly=true)
	public Integer countTotal(){
		return (Integer) sessionFactory.getCurrentSession().createCriteria(Role.class).
				add(Restrictions.eq(Role.ENABLED, true)).
				setProjection(Projections.rowCount()).list().get(0);
	}

}

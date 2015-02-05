/**
 * 
 */
package ph.yondu.foosher.cms.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ph.yondu.foosher.cms.dao.UserDao;
import ph.yondu.foosher.cms.domains.Role;
import ph.yondu.foosher.cms.domains.User;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#save(ph.yondu.foosher.cms.domains.User)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#list()
	 */
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("enabled", true)).list();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#get(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public User get(Long id) {
		return  (User) sessionFactory.
				getCurrentSession().
				createCriteria(User.class).
				add(Restrictions.eq("enabled", true)).
				add(Restrictions.eq("id", id)).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#disable(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void disable(Long id) {
		String hqlUpdate = "update User set enabled = :user_enabled where id = :user_id";
		sessionFactory.getCurrentSession().createQuery( hqlUpdate )
		        .setBoolean( "user_enabled", false )
		        .setLong( "user_id", id )
		        .executeUpdate();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#getInitialized(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public User getInitialized(Long id) {
		User user = (User) sessionFactory.
				getCurrentSession().
				createCriteria(User.class).
				add(Restrictions.eq("enabled", true)).
				add(Restrictions.eq("id", id)).uniqueResult();
		if(user != null){
			Hibernate.initialize(user.getRoles());
		}	
		return user;
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#findByUsername(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		User user = (User) sessionFactory.
				getCurrentSession().
				createCriteria(User.class).
				add(Restrictions.eq("enabled", true)).
				add(Restrictions.like("username", username)).uniqueResult();
		if(user != null){
			Hibernate.initialize(user.getRoles());
		}	
		return user;
	}

}

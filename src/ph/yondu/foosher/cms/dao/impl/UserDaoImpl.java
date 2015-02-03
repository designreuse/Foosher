/**
 * 
 */
package ph.yondu.foosher.cms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ph.yondu.foosher.cms.dao.UserDao;
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
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.dao.UserDao#list()
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<User> list() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("enabled", true)).list();
	}

}

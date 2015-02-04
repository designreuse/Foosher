/**
 * 
 */
package ph.yondu.foosher.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import ph.yondu.foosher.cms.dao.RoleDao;
import ph.yondu.foosher.cms.dao.UserDao;
import ph.yondu.foosher.cms.domains.Role;
import ph.yondu.foosher.cms.domains.User;
import ph.yondu.foosher.cms.service.UserService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired UserDao userDao;	
	@Autowired RoleDao roleDao;
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#save(ph.yondu.foosher.cms.domains.User)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(User user) {
		userDao.save(user);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#list()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<User> list() {
		return userDao.list();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#get(java.lang.Long, boolean)
	 */
	@Override
	@Transactional(readOnly=true)
	public User get(Long id, boolean isInitialized) {
		if(isInitialized){
			return userDao.getInitialized(id);
		}
		return userDao.get(id);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#disable(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void disable(Long id) {
		userDao.disable(id);
	}


}

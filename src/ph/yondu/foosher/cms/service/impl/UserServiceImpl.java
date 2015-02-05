/**
 * 
 */
package ph.yondu.foosher.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	public void save(User user) {
		userDao.save(user);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#list()
	 */
	@Override
	public List<User> list() {
		return userDao.list();
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#get(java.lang.Long, boolean)
	 */
	@Override
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
	public void disable(Long id) {
		userDao.disable(id);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	
}

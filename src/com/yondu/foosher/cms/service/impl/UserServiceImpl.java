/**
 * 
 */
package com.yondu.foosher.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yondu.foosher.cms.dao.RoleDao;
import com.yondu.foosher.cms.dao.UserDao;
import com.yondu.foosher.cms.domains.User;
import com.yondu.foosher.cms.service.UserService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired UserDao userDao;	
	@Autowired RoleDao roleDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public User get(Long id, boolean isInitialized) {
		if(isInitialized){
			return userDao.getInitialized(id);
		}
		return userDao.get(id);
	}

	@Override
	public void disable(Long id) {
		userDao.disable(id);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
}

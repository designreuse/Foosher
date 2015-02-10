/**
 * 
 */
package com.yondu.foosher.cms.dao;

import java.util.List;

import com.yondu.foosher.cms.domains.User;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface UserDao {

	void save(User user);
	List<User> list();
	User get(Long id);
	User getInitialized(Long id);
	void disable(Long id);
	User findByUsername(String username);
}

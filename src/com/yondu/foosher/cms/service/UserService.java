/**
 * 
 */
package com.yondu.foosher.cms.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yondu.foosher.cms.domains.User;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface UserService {

	void save(User user);
	List<User> list();
	User get(Long id, boolean isInitialized);
	void disable(Long id);
	User findByUsername(String username);
	void sendEmailConfirmation();
}

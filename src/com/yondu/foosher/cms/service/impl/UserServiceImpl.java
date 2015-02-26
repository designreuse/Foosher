/**
 * 
 */
package com.yondu.foosher.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
	@Autowired MailSender mailSender;
	
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

	@Override
	public void sendEmailConfirmation() {
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom("email.ni.sean@gmail.com");
		message.setTo("email_ni_sean@yahoo.com");
		message.setSubject("Testing 123");
		message.setText("Texting 123");
		mailSender.send(message);	
	}
	
}

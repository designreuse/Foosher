/**
 * 
 */
package com.yondu.foosher.basic.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author S.FORTUNATO
 *
 */
@Controller
public class IndexController {
	Logger logger = Logger.getLogger("test");
	
    @RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "redirect:dashboard.html";
	}
    
    @RequestMapping(value="/dashboard.html", method = RequestMethod.GET)
    public String dashboard(){
    	return "dashboardTemplate";
    }
    
    @RequestMapping(value="/login.html", method=RequestMethod.GET)
    public String login(){
    	logger.info(new Md5PasswordEncoder().encodePassword("admin", null).toString());
    	return "loginForm";
    }
	
}

/**
 * 
 */
package ph.yondu.foosher.basic.controllers;

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
		return "publicTemplate"; //TODO: temporary lang ito
	}
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(){
    	logger.info(new Md5PasswordEncoder().encodePassword("admin", null).toString());
    	return "loginForm";
    }
	
}

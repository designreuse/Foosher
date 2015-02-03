/**
 * 
 */
package ph.yondu.foosher.basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author S.FORTUNATO
 *
 */
@Controller
public class IndexController {
	
    @RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "dashboardTemplate"; //TODO: temporary lang ito
	}
	
}

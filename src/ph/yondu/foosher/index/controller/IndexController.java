/**
 * 
 */
package ph.yondu.foosher.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author S.FORTUNATO
 *
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception {
        return new ModelAndView("index");
    }
	
}

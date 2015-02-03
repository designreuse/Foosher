/**
 * 
 */
package ph.yondu.foosher.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ph.yondu.foosher.cms.dao.RoleDao;
import ph.yondu.foosher.cms.dao.UserDao;
import ph.yondu.foosher.cms.domains.User;


/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller @RequestMapping("/admin/cms/user")
public class UserController {

	@Autowired UserDao userDao;
	@Autowired RoleDao roleDao;
	
	@RequestMapping(value="/add.htm",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("userModel", new User());
		model.addAttribute("roles", roleDao.list());
		return "userForm";
	}

	//TODO ADD VALIDATION
	@RequestMapping(value="/save.htm", method=RequestMethod.POST)
	public String save(@ModelAttribute("userModel") User user, 
			final RedirectAttributes redirectAttributes,
			Model model){
//		model.addAttribute("roles", roleDao.list());
		userDao.save(user);
		redirectAttributes.addFlashAttribute("message", "Successfully added user " + user.getUsername());
		return "redirect:add.htm";
	}
	
}

/**
 * 
 */
package ph.yondu.foosher.cms.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ph.yondu.foosher.cms.domains.Role;
import ph.yondu.foosher.cms.domains.User;
import ph.yondu.foosher.cms.service.RoleService;
import ph.yondu.foosher.cms.service.UserService;


/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller 
@RequestMapping("/admin/cms/user")
public class UserController {

	@Autowired UserService userService;
	@Autowired RoleService roleService;
	private Map<String, Role> roleCache;
	
	@RequestMapping(value="/add.htm",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("userModel", new User());
		model.addAttribute("activeRoles",getActiveRoles());
		return "userAddForm";
	}
	
	@RequestMapping(value="/add.htm", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute("userModel") @Valid User user, 
			BindingResult bindingResult,
			final RedirectAttributes redirectAttributes,
			Model model){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("userModel", user);
			model.addAttribute("activeRoles", getActiveRoles());
			return "userAddForm";
		} else {
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "Successfully added user " + user.getUsername());
			return "redirect:add.htm";
		}
		
	}
	
	@RequestMapping(value="/edit.htm", method=RequestMethod.GET)
	public String editForm(@RequestParam(value="id", defaultValue="0", required=true) Long id, Model model){
		model.addAttribute("userModel", userService.get(id, true));
		model.addAttribute("activeRoles",getActiveRoles());
		return "userEditForm";
	}

	//TODO: Nagcreate ng bago instance si user, ausin ok? :D
	@RequestMapping(value="/edit.htm", method=RequestMethod.POST)
	public String update(
			@ModelAttribute("userModel") @Valid User user, 
			BindingResult bindingResult,
			final RedirectAttributes redirectAttributes,
			Model model){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("userModel", user);
			model.addAttribute("activeRoles", getActiveRoles());
			return "userEditForm";
		} else {
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "Successfully updated user " + user.getUsername());
			return "redirect:edit.htm?id="+ user.getId();
		}
		
	}
	
	@RequestMapping(value="/list.htm", method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", userService.list());
		return "userList";
	}
	
	@RequestMapping(value="/disable.htm", method=RequestMethod.GET)
	public String disable(@RequestParam(value="id", defaultValue="0", required=true) Long id,
			final RedirectAttributes redirectAttributes){
		userService.disable(id);
		redirectAttributes.addFlashAttribute("message", "Successfully removed user with ID " + id);
		return "redirect:list.htm";
	}
	

	private List<Role> getActiveRoles(){
		List<Role> activeRoles = roleService.list();
		roleCache = new HashMap<String, Role>();
		for (Role role : activeRoles) {
			roleCache.put(role.getIdString(), role);
		}
		return activeRoles;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "roles", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Role) {
					System.out.println("Converting from Role to Role: " + element);
					return element;
				}
				if (element instanceof String) {
					Role role = roleCache.get(element);
					System.out.println("Looking up role for id " + element + ": " + role);
					return role;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
}

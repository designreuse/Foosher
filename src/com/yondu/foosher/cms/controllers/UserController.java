/**
 * 
 */
package com.yondu.foosher.cms.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yondu.foosher.cms.domains.Role;
import com.yondu.foosher.cms.domains.User;
import com.yondu.foosher.cms.service.RoleService;
import com.yondu.foosher.cms.service.UserService;
import com.yondu.foosher.cms.validators.UserValidator;


/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller 
@RequestMapping("/cms/user")
public class UserController {

	@Autowired UserValidator userValidator;
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	private Map<String, Role> roleCache;
	
	@RequestMapping(value="/add.html",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("userModel", new User());
		model.addAttribute("activeRoles",getActiveRoles());
		return "userAddForm";
	}
	
	@RequestMapping(value="/add.html", method=RequestMethod.POST)
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
			user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "Successfully added user " + user.getUsername());
			return "redirect:add.html";
		}
		
	}
	
	@RequestMapping(value="/edit.html", method=RequestMethod.GET)
	public String editForm(@RequestParam(value="id", defaultValue="0", required=true) Long id, Model model){
		model.addAttribute("userModel", userService.get(id, true));
		model.addAttribute("activeRoles",getActiveRoles());
		return "userEditForm";
	}

	@RequestMapping(value="/edit.html", method=RequestMethod.POST)
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
			user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "Successfully updated user " + user.getUsername());
			return "redirect:edit.html?id="+ user.getId();
		}
		
	}
	
	@RequestMapping(value="/list.htm", method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", userService.list());
		return "userList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list.json")
	public String getUsersJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(userService.get(1L, true));
		Logger.getLogger(this.getClass()).info(json);
		return json;
	}
	
	@RequestMapping(value="/disable.html", method=RequestMethod.GET)
	public String disable(@RequestParam(value="id", defaultValue="0", required=true) Long id,
			final RedirectAttributes redirectAttributes){
		userService.disable(id);
		redirectAttributes.addFlashAttribute("message", "Successfully removed user with ID " + id);
		return "redirect:list.html";
	}
	

	private List<Role> getActiveRoles(){
		List<Role> activeRoles = roleService.list();
		roleCache = new HashMap<String, Role>();
		for (Role role : activeRoles) {
			roleCache.put(role.getIdString(), role);
		}
		return activeRoles;
	}
	
//	@RequestMapping(value="/download.html")
//	public void download(@RequestParam String type,	@RequestParam String token ,HttpServletResponse response) {
//		userService.download(type, token, response);
//	} 
//	
	
	@RequestMapping(value = "foosher1", method = RequestMethod.GET)
	public String getPdf(Model model) {
		model.addAttribute("datasource", userService.list());
		model.addAttribute("format", "pdf");
		return "foosher1";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.setValidator(userValidator);
		
		binder.registerCustomEditor(List.class, "roles", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Role) {
					Logger.getLogger(this.getClass()).debug("Converting from Role to Role: " + element);
					return element;
				}
				
				if (element instanceof String) {
					Role role = roleCache.get(element);
					Logger.getLogger(this.getClass()).debug("Looking up role for id " + element + ": " + role);
					return role;
				}
				Logger.getLogger(this.getClass()).debug("Don't know what to do with: " + element);
				return null;
			}
		});
		
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), false));
	}

	
}

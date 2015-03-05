/**
 * 
 */
package com.yondu.foosher.cms.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yondu.foosher.basic.dto.FoosherPagedListHolder;
import com.yondu.foosher.cms.domains.Role;
import com.yondu.foosher.cms.service.RoleService;
import com.yondu.foosher.cms.validators.RoleValidator;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller 
@RequestMapping("/cms/role")
public class RoleController {

	@Autowired RoleService roleService;
	@Autowired RoleValidator roleValidator;
	
	@RequestMapping(value="/add.html",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("roleModel", new Role());
		return "roleAddForm";
	}
	
	@RequestMapping(value="/add.html", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute("roleModel") @Valid Role role, 
			BindingResult bindingResult,
			final RedirectAttributes redirectAttributes,
			Model model){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("roleModel", role);
			return "roleAddForm";
		} else {
			roleService.save(role);
			redirectAttributes.addFlashAttribute("message", "Successfully added role " + role.getDescription());
			return "redirect:add.html";
		}
		
	}
	
	@RequestMapping(value="/edit.html", method=RequestMethod.GET)
	public String editForm(
			@RequestParam(value="id", defaultValue="0", required=true) Long id, 
			Model model){
		
		model.addAttribute("roleModel", roleService.get(id, false));
		return "roleEditForm";
	}

	@RequestMapping(value="/edit.html", method=RequestMethod.POST)
	public String update(
			@ModelAttribute("roleModel") @Valid Role role, 
			BindingResult bindingResult,
			final RedirectAttributes redirectAttributes,
			Model model){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("roleModel", role);
			return "roleEditForm";
		} else {
			roleService.save(role);
			redirectAttributes.addFlashAttribute("message", "Successfully updated role " + role.getDescription());
			return "redirect:edit.html?id="+role.getId();
		}
		
	}
	
	@RequestMapping(value="/list.html", method=RequestMethod.GET)
	public String list(
			@RequestParam(value="page", defaultValue="0", required=true) int page,
			@RequestParam(value="size", defaultValue="10", required=true) int size,
			@RequestParam(value="resort", defaultValue="false", required=true) boolean resort,
			@RequestParam(value="column", defaultValue="description", required=true) String column,
			@RequestParam(value="ascending", defaultValue="true", required=true) boolean isAscending,
			@RequestParam(value="searchName", defaultValue="", required=false) String searchName,
			@RequestParam(value="searchCategory", defaultValue="",  required=false) String searchCategory,
			Model model){
		List<Role> roles = roleService.list(column, isAscending, searchName, searchCategory);
		FoosherPagedListHolder<Role> rolePagination = new FoosherPagedListHolder<Role>(roles);
		rolePagination.setPage(page);
		rolePagination.setPageSize(size);
		rolePagination.setColumn(column);
		rolePagination.setIsAscending(isAscending);
		rolePagination.setSearchName(searchName);
		rolePagination.setSearchCategory(searchCategory);
		rolePagination.setCountTotal(roles.size());
		model.addAttribute("pagination", rolePagination);
		return "roleList";
	}

	@RequestMapping(value="/disable.html", method=RequestMethod.GET)
	public String disable(
			@RequestParam(value="id", defaultValue="0", required=true) Long id,
			final RedirectAttributes redirectAttributes){
		
		roleService.disable(id);
		redirectAttributes.addFlashAttribute("message", "Successfully removed role with ID " + id);
		return "redirect:list.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list.json")
	public String getRolesJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(roleService.get(1L, true));
		Logger.getLogger(this.getClass()).info(json);
		return json;
	}
	
	/**
	 * Need ito para magmatch ung format ng date sa jstl at model na nasa controller
	 * @param binder
	 */
	@InitBinder("roleModel")
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    binder.addValidators(roleValidator);
	}
	
	
}

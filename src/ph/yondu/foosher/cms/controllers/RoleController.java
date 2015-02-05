/**
 * 
 */
package ph.yondu.foosher.cms.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ph.yondu.foosher.cms.dao.RoleDao;
import ph.yondu.foosher.cms.domains.Role;
import ph.yondu.foosher.cms.service.RoleService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller 
@RequestMapping("/admin/cms/role")
public class RoleController {

	@Autowired RoleService roleService;
	
	@RequestMapping(value="/add.htm",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("roleModel", new Role());
		return "roleAddForm";
	}
	
	@RequestMapping(value="/add.htm", method=RequestMethod.POST)
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
			return "redirect:add.htm";
		}
		
	}
	
	@RequestMapping(value="/edit.htm", method=RequestMethod.GET)
	public String editForm(@RequestParam(value="id", defaultValue="0", required=true) Long id, Model model){
		model.addAttribute("roleModel", roleService.get(id, false));
		return "roleEditForm";
	}

	//TODO add feedback text whether success or fail
	@RequestMapping(value="/edit.htm", method=RequestMethod.POST)
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
			return "redirect:edit.htm?id="+role.getId();
		}
		
	}
	
	@RequestMapping(value="/list.htm", method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("roles", roleService.list());
		return "roleList";
	}
	
	@RequestMapping(value="/disable.htm", method=RequestMethod.GET)
	public String disable(@RequestParam(value="id", defaultValue="0", required=true) Long id,
			final RedirectAttributes redirectAttributes){
		roleService.disable(id);
		redirectAttributes.addFlashAttribute("message", "Successfully removed role with ID " + id);
		return "redirect:list.htm";
	}
	
	
	/**
	 * Need ito para magmatch ung format ng date sa jstl at model na nasa controller
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}

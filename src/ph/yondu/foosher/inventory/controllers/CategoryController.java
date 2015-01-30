/**
 * 
 */
package ph.yondu.foosher.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ph.yondu.foosher.inventory.dao.CategoryDao;
import ph.yondu.foosher.inventory.domains.Category;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller
@RequestMapping("/admin/inventory/category")
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/add.htm",  method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("categoryModel", new Category());

		return "categoryAdd";
	}

	//TODO add feedback text whether success or fail
	@RequestMapping(value="/add.htm", method=RequestMethod.POST)
	public String save(@ModelAttribute("categoryModel") Category category, Model model){
		categoryDao.save(category);
		return "categoryAdd";
	}
	
}

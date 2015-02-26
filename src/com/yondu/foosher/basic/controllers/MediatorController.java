/**
 * 
 */
package com.yondu.foosher.basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller
@RequestMapping("/")
public class MediatorController {

    @RequestMapping
	public String getDashboard(){
		return "redirect:dashboard.html";
	}
}

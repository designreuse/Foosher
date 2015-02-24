/**
 * 
 */
package com.yondu.foosher.cms.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yondu.foosher.cms.domains.Upload;
import com.yondu.foosher.cms.service.UploadService;
import com.yondu.foosher.cms.validators.UploadValidator;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller
@RequestMapping("/cms/file/")
public class UploadController{
	
	@Autowired UploadService uploadService;
	@Autowired UploadValidator uploadValidator;
	
	@RequestMapping(value="upload.html", method=RequestMethod.GET)
	public String uploadForm(){
		return "uploadForm";
	}

	@RequestMapping(value="upload.html", method=RequestMethod.POST)
	public String saveUpload(
			@ModelAttribute("uploadModel") @Valid Upload files,
			BindingResult result, Model model, RedirectAttributes redirectAttributes){
		if (result.hasErrors()) {
			return "uploadForm";
		} else {
			int counter = 0;
			for(MultipartFile file : files.getFiles()){
				if(!file.isEmpty()){
					uploadService.saveImage(file, counter++);
				}  
			}
			redirectAttributes.addFlashAttribute("message", "Successfully uploaded image/s");
			return "redirect:upload.html";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.addValidators(uploadValidator);
	}
	
}

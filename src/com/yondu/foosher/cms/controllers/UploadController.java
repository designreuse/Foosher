/**
 * 
 */
package com.yondu.foosher.cms.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yondu.foosher.cms.service.UploadService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Controller
@RequestMapping("/admin/cms/file/")
public class UploadController{
	
	@Autowired
	UploadService uploadService;

	@RequestMapping(value="upload", method=RequestMethod.GET)
	public String getFileForm(){
		return "fileAddForm";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String uploadFile(
//			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile multipartFile){
		uploadService.save(multipartFile, "bago");
		return "fileAddForm";
	}

}

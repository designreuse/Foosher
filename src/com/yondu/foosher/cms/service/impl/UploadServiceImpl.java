/**
 * 
 */
package com.yondu.foosher.cms.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.yondu.foosher.cms.dao.UploadDao;
import com.yondu.foosher.cms.domains.Upload;
import com.yondu.foosher.cms.service.UploadService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService, ServletContextAware {

	private ServletContext servletContext;
	@Autowired UploadDao uploadDao;
	
	@Override
	public void save(MultipartFile multipartFile, String description) {
		String todayAsString = new SimpleDateFormat("ddMMyyyyhhmm").format(new Date());
		String filePath = servletContext.getRealPath("/") + "/uploads/" + todayAsString + ".jpg";
		File file = new File(filePath);
		try {
			FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
			Upload myFile = new Upload();
			myFile.setDescription(description);
			myFile.setPath(filePath);
			uploadDao.save(myFile);
		} catch (IOException e) {
			Logger.getLogger(this.getClass()).info("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
			Logger.getLogger(this.getClass()).debug(e);
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}

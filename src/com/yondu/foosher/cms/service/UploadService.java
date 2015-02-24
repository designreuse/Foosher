/**
 * 
 */
package com.yondu.foosher.cms.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface UploadService {

	void saveImage(MultipartFile multipartFile, int increments);
	
}

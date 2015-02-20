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

	void save(MultipartFile multipartFile, String description);
	
}

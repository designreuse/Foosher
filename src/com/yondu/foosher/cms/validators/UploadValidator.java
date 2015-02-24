/**
 * 
 */
package com.yondu.foosher.cms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.yondu.foosher.cms.domains.Upload;


/**
 * @author Sean Ross M. Fortunato
 *\
 */
@Component
public class UploadValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Upload.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Upload upload = (Upload) obj;

		for(MultipartFile multipartFile : upload.getFiles()){
			if(multipartFile.isEmpty()){
				errors.rejectValue("files", "cms.upload.file.notempty");
			}
		}
	}

}

/**
 * 
 */
package com.yondu.foosher.cms.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Component
public class RoleValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return Role.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "cms.role.description.notempty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "cms.role.code.notempty");
	}

}

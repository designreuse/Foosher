/**
 * 
 */
package com.yondu.foosher.cms.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yondu.foosher.cms.domains.User;
import com.yondu.foosher.cms.service.UserService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Component
public class UserValidation implements Validator {
	
	@Autowired
	UserService userService;

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "cms.user.username.notempty");
		String username = user.getUsername();
	    if (username != null && userService.findByUsername(username) != null) {
	        errors.rejectValue("username", "cms.user.username.exists");
	    }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "cms.user.password.notempty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "cms.user.email.notempty");
		if(!user.getPassword().equals(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "cms.user.confirmPassword");
		}
		if(!user.getEmail().equals(user.getConfirmEmail())){
			errors.rejectValue("confirmEmail", "cms.user.confirmEmail");
		}
		if(user.getEmail() != null && !user.getEmail().isEmpty()){
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher = pattern.matcher(user.getEmail());
			if(!matcher.matches()){
				errors.rejectValue("email", "cms.user.email.pattern");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "cms.user.firstname.notempty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "cms.user.lastname.notempty");
	}

}

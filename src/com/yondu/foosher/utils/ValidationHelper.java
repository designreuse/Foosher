/**
 * 
 */
package com.yondu.foosher.utils;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Component
public class ValidationHelper {

	public boolean hasEmpty(Object... obj) {	    
        for(Object o : obj) {    
            if(isHallow(o))
            	return true;
        } 
        
        return false;
	}
	
	public boolean hasNoEmpty(Object... obj) {
	    return !hasEmpty(obj);
	}
		
	public boolean isEmpty(Object... obj) {
		for(Object o : obj) {
			if(!isHallow(o))
				return false;
		}
		
		return true;
	}
	
	public boolean isNotEmpty(Object... obj) {
		return !isEmpty(obj);
	}
	
	public boolean isHallow(Object o) {
        if(o instanceof String && StringUtils.isBlank((String) o)) {
            return true;
        }
        else if (o instanceof Collection && ((Collection) o).isEmpty()) {
        	return true;        	
        }
        else if(isNull(o)) {
            return true;
        }
        
        return false;
	}
	
	public boolean isNotHallow(Object o) {
		return !isHallow(o);
	}
	
	
	public void validate(String errorMessage, Object... obj) throws Exception {	    
        if(hasEmpty(obj)) {
            throw new Exception(errorMessage);
        }
	}
	
	public boolean isNull(Object obj) {
	    return (obj == null);
	}
	
	public boolean checkString(String s, String pattern) {		
		return s.matches(pattern);
	}
	
}

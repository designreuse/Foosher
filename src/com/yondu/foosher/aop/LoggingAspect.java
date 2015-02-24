/**
 * 
 */
package com.yondu.foosher.aop;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * @author Sean Ross M. Fortunato
 *
 */
@Aspect 
@Component
public class LoggingAspect {

	@Before("execution(public void save(..))")  
	public void saveAdvice(JoinPoint joinPoint) {
		
        Object object = joinPoint.getArgs()[0];
        
        try {
        	
    		Field key = object.getClass().getDeclaredField("id");
    		key.setAccessible(true);
    		
    		if (key.get(object) == null) {
                Field createdAt = object.getClass().getSuperclass().getDeclaredField("createdAt");

                createdAt.setAccessible(true);
                createdAt.set(object, new Date());
                
                Field enabled = object.getClass().getSuperclass().getDeclaredField("enabled");
                enabled.setAccessible(true);
                enabled.set(object,  true);

            } else {
                Field updatedAt = object.getClass().getSuperclass().getDeclaredField("updatedAt");

                updatedAt.setAccessible(true);
                updatedAt.set(object, new Date());
            }
		
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).info("An error has occured in logging aspect.");
            Logger.getLogger(this.getClass()).debug(e);
        }
	}
}

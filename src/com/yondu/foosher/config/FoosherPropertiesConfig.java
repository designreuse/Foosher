/**
 * 
 */
package com.yondu.foosher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Configuration
@PropertySource("classpath:${APP_ENV:default}.properties")
public class FoosherPropertiesConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}

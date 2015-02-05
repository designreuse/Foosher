/**
 * 
 */
package ph.yondu.foosher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import ph.yondu.foosher.cms.service.UserService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Configuration
@EnableWebSecurity
public class FoosherSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
//	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
		auth.userDetailsService(userDetailsService).passwordEncoder(new Md5PasswordEncoder());
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
//	  http.authorizeRequests()
//		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
// 
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/**").access("hasRole('ROLE_ANONYMOUS')")
		.and().formLogin()
		.loginPage("/login")
		.failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
//		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");
	}
	
}

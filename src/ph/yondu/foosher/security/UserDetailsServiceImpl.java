/**
 * 
 */
package ph.yondu.foosher.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ph.yondu.foosher.cms.dao.UserDao;
import ph.yondu.foosher.cms.domains.Role;
import ph.yondu.foosher.cms.domains.User;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
 
		return buildUserForAuthentication(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, 
		List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (Role role : roles) {
			setAuths.add(new SimpleGrantedAuthority(role.getCode()));
		}
 
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
 
		return result;
	}
}

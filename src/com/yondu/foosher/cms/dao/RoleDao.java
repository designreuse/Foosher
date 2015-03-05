/**
 * 
 */
package com.yondu.foosher.cms.dao;

import java.util.List;

import com.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface RoleDao {

	/**
	 * Save or update the given role
	 */
	void save(Role role);
	
	/**
	 * Return a list of all roles
	 */
	List<Role> list();

	/**
	 * Returns "LAZY" fetched role depending on the given id
	 */
	Role get(Long id);
	
	/**
	 * Returns "EAGER" fetched role depending on the given id
	 */
	Role getInitialized(Long id);
	
	/**
	 * Disables the role
	 */
	void disable(Long id);
	
	/**
	 * Used for pagination and returns a list of roles depending on the given parameters
	 */
	List<Role> list(String column, boolean isAscending, String searchName, String searchCategory);
	
	/**
	 * Returns total number of roles
	 */
	Integer countTotal();
}

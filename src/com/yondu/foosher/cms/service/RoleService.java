/**
 * 
 */
package com.yondu.foosher.cms.service;

import java.util.List;

import com.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface RoleService {

	/**
	 * Save the role
	 */
	void save(Role role);
	
	/**
	 * Returns all roles
	 */
	List<Role> list();
	
	/**
	 * Return a single role depending on the given id 
	 * if the given second parameter is true then the fetch type is EAGER
	 * otherwise the fetch type is LAZY
	 */
	Role get(Long id, boolean isInitialized);
	
	/**
	 * Disable the role
	 */
	void disable(Long id);
	
	/**
	 * Returns specific roles based on the given parameters
	 * 1st parameter is column name of the role that you want to sort
	 * 2nd parameter is to indicate the sort type, it is ascending if the given is true and vice versa
	 * 3rd parameter is the keyword you are searching
	 * 4th parameter is the column name where you want to search the keyword from
	 */
	List<Role> list(String column, boolean isAscending, String searchName, String searchCategory);
	
	/**
	 * Returns the total number of roles
	 */
	Integer countTotal();
}

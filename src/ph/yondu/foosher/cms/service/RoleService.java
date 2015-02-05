/**
 * 
 */
package ph.yondu.foosher.cms.service;

import java.util.List;

import ph.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface RoleService {

	void save(Role role);
	List<Role> list();
	Role get(Long id, boolean isInitialized);
	void disable(Long id);
	
}

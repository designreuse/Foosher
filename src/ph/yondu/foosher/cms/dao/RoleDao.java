/**
 * 
 */
package ph.yondu.foosher.cms.dao;

import java.util.List;

import ph.yondu.foosher.cms.domains.Role;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface RoleDao {

	void save(Role role);
	List<Role> list();
	Role get(Long id);
	void disable(Long id);
}

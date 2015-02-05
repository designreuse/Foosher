/**
 * 
 */
package ph.yondu.foosher.cms.dao;

import java.util.List;

import ph.yondu.foosher.cms.domains.User;

/**
 * @author Sean Ross M. Fortunato
 *
 */
public interface UserDao {

	void save(User user);
	List<User> list();
	User get(Long id);
	void disable(Long id);
	User getInitialized(Long id);
	User findByUsername(String username);
}

/**
 * 
 */
package com.yondu.foosher.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yondu.foosher.cms.dao.RoleDao;
import com.yondu.foosher.cms.domains.Role;
import com.yondu.foosher.cms.service.RoleService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> list() {
		return roleDao.list();
	}
	
	@Override
	public void disable(Long id) {
		roleDao.disable(id);
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public Role get(Long id, boolean isInitialized) {
		if(isInitialized){
			return roleDao.getInitialized(id);
		}
		return roleDao.get(id);
	}

	@Override
	public List<Role> list(String column, boolean isAscending,
			String searchName, String searchCategory) {
		return roleDao.list(column, isAscending, searchName, searchCategory);
	}

	@Override
	public Integer countTotal() {
		return roleDao.countTotal();
	}

}

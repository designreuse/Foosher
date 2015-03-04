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
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.RoleService#list()
	 */
	@Override
	public List<Role> list() {
		return roleDao.list();
	}
	
	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.RoleService#disable(java.lang.Long)
	 */
	@Override
	public void disable(Long id) {
		roleDao.disable(id);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.RoleService#save(ph.yondu.foosher.cms.domains.Role)
	 */
	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	/* (non-Javadoc)
	 * @see ph.yondu.foosher.cms.service.RoleService#get(java.lang.Long, boolean)
	 */
	@Override
	public Role get(Long id, boolean isInitialized) {
		if(isInitialized){
			return roleDao.getInitialized(id);
		}
		return roleDao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.yondu.foosher.cms.service.RoleService#list(java.lang.String, boolean, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Role> list(String column, boolean isAscending,
			String searchName, String searchCategory) {
		return roleDao.list(column, isAscending, searchName, searchCategory);
	}

}

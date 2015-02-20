/**
 * 
 */
package com.yondu.foosher.cms.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yondu.foosher.cms.dao.UploadDao;
import com.yondu.foosher.cms.domains.Upload;
import com.yondu.foosher.cms.service.UploadService;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Repository("fileDao")
public class UploadDaoImpl implements UploadDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Upload upload) {
		sessionFactory.getCurrentSession().save(upload);
	}

}

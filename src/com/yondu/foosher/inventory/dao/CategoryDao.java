package com.yondu.foosher.inventory.dao;

import java.util.List;

import com.yondu.foosher.inventory.domains.Category;

public interface CategoryDao {

	void save(Category category);
	List<Category> list();
	
}

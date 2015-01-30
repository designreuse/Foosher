package ph.yondu.foosher.inventory.dao;

import java.util.List;

import ph.yondu.foosher.inventory.domains.Category;

public interface CategoryDao {

	void save(Category category);
	List<Category> list();
	
}

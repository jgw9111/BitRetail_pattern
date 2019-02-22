package dao;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryDAO {
	public void insertCategory(CategoryDTO cate);
    public List<CategoryDTO> selectCategoryLists(Proxy pxy);
    public List<CategoryDTO> selectCategorys(String city);
    public CategoryDTO selectCategory(String categoryId);
    public int countCategory();
    public boolean existsCategory(String categoryId);
    public void updateCategory(CategoryDTO cate);
    public void deleteCategory(CategoryDTO cate);
}

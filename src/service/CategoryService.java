package service;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryService {
	public void joinCategory(CategoryDTO cate);
    public List<CategoryDTO> bringCategoryLists(Proxy pxy);
    public List<CategoryDTO> retrieveCategorys(String city);
    public CategoryDTO retrieveCategory(String categoryId);
    public int countCategory();
    public boolean existsCategory(String categoryId);
    public void modifyCategory(CategoryDTO cate);
    public void removeCategory(CategoryDTO cate);
	
}

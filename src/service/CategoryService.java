package service;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryService {
	public void registerCategory(CategoryDTO cat);
	public List<CategoryDTO> bringCategories();
	public List<CategoryDTO> retrieveCategories(String searchWord);
	
}

package service;

import java.util.List;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.Proxy;

public class CategoryServiceImpl implements CategoryService {
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	public CategoryServiceImpl() { dao = CategoryDAOImpl.getInstance();}
	public static CategoryServiceImpl getInstance() {return instance;}
	CategoryDAO dao;

	@Override
	public void joinCategory(CategoryDTO cate) {
		dao.insertCategory(cate);
	}
	@Override
	public List<CategoryDTO> bringCategoryLists(Proxy pxy) {
		return dao.selectCategoryLists(pxy);
	}
	@Override
	public List<CategoryDTO> retrieveCategorys(String city) {
		return dao.selectCategorys(city);
	}
	@Override
	public CategoryDTO retrieveCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean existsCategory(String categoryId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void modifyCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}


}

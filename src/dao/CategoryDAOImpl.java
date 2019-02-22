package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import domain.CustomerDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabasFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO {
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	Connection conn;
	public CategoryDAOImpl() {conn = DatabasFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static CategoryDAO getInstance() {
		return new CategoryDAOImpl();
	}
	@Override
	public void insertCategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<CategoryDTO> selectCategoryLists(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(CategorySQL.CATE_LIST.toString());
			Pagination page = ((PageProxy)pxy).getPage();
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			pstmt.setString(1, startRow);
			pstmt.setString(2, endRow);
			ResultSet rs =pstmt.executeQuery();
			CategoryDTO cate = null;
			while(rs.next()) {
				cate = new CategoryDTO();
				cate.setCategoryId(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		}
	@Override
	public List<CategoryDTO> selectCategorys(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryDTO selectCategory(String categoryId) {
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
	public void updateCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}

}

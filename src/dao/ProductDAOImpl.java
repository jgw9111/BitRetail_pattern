package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ProductDTO;
import enums.Vendor;
import factory.DatabasFactory;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO{
	Connection conn ;
	private static ProductDAOImpl instance = new ProductDAOImpl();
	public ProductDAOImpl() { conn = DatabasFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static ProductDAOImpl getInstance() {return instance;}

	@Override
	public void insertProduct(ProductDTO pro) {
		try {
			String sql ="";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductDTO> selectproductsList(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<ProductDTO> selectProducts(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public ProductDTO selectProduct(ProductDTO img) {
		ProductDTO pro = new ProductDTO();
		return pro;
	}

	@Override
	public int countProducts(Proxy pxy) {
		int procount = 0;
		return procount;
	}

	@Override
	public void updateProduct(ProductDTO pro) {
		
	}

	@Override
	public void deleteProduct(ProductDTO pro) {
		
	}

}

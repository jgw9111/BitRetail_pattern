package service;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{
	private static ProductServiceImpl instance = new ProductServiceImpl();
	public ProductServiceImpl() {dao = ProductDAOImpl.getInstance();}
	public static ProductServiceImpl getInstance() {return instance;}
	ProductDAO dao;
	
	@Override
	public void addProduct(ProductDTO pro) {
		dao.insertProduct(pro);
	}

	@Override
	public List<ProductDTO> productsList(Proxy pxy) {
		return dao.selectproductsList(pxy);
	}

	@Override
	public List<ProductDTO> searchProducts(Proxy pxy) {
		return dao.selectProducts(pxy);
	}

	@Override
	public ProductDTO searchProduct(ProductDTO pro) {
		return dao.selectProduct(pro);
		
	}

	@Override
	public int countProducts(Proxy pxy) {
		return dao.countProducts(pxy);
	}

	@Override
	public void updateProduct(ProductDTO pro) {
		dao.updateProduct(pro);
	}

	@Override
	public void removeProduct(ProductDTO pro) {
		dao.deleteProduct(pro);
	}

}

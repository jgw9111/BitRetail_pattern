package dao;

import java.util.List;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {
	public void insertProduct(ProductDTO pro);
	public List<ProductDTO> selectproductsList(Proxy pxy);
	public List<ProductDTO> selectProducts(Proxy pxy);
	public ProductDTO selectProduct(ProductDTO img);
	public int countProducts(Proxy pxy);
	public void updateProduct(ProductDTO pro);
	public void deleteProduct(ProductDTO pro);
}

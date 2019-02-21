package service;

import java.util.List;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductService {
	public void addProduct(ProductDTO pro);
	public List<ProductDTO> productsList(Proxy pxy);
	public List<ProductDTO> searchProducts(Proxy pxy);
	public ProductDTO searchProduct(ProductDTO pro);
	public int countProducts(Proxy pxy);
	public void updateProduct(ProductDTO pro);
	public void removeProduct(ProductDTO pro);
}

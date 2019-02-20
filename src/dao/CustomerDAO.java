package dao;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Pagination;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDTO> selectCustomersList(Proxy pxy);
	public List<CustomerDTO> selectCustomers(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomers(Proxy pxy);
	public boolean existCustomerId(CustomerDTO cus);
	public Map<String, Object> selectProfile(Proxy pxy);
	public void deleteCustomer(CustomerDTO cus);
	public void updateCustomer(CustomerDTO cus);
	public Map<String, Object> selectPhone(Proxy pxy);
	public CustomerDTO selectCustomerOne(CustomerDTO cus);
	/*public void updateImage(CustomerDTO cus);*/
}

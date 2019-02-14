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
	public void updateCustomer(CustomerDTO cus);
	public void deleteCustomer(CustomerDTO cus);
	public Map<String, Object> selectPhone(Proxy pxy);
}

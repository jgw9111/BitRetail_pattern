package dao;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagenation;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDTO> selectCustomersList(Pagenation page);
	public List<CustomerDTO> selectCustomers(String searchWord);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomers();
	public boolean existCustomerId(CustomerDTO cus);
	public void updateCustomer(CustomerDTO cus);
	public void deleteCustomer(CustomerDTO cus);
}

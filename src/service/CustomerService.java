package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagenation;

public interface CustomerService {
	public void joinCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomersList(Pagenation page);
	public List<CustomerDTO> retrieveCustomers(String searchWord);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomers();
	public boolean existCustomerId(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}

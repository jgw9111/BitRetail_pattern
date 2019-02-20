package service;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerService {
	public void joinCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomersList(Proxy pxy);
	public List<CustomerDTO> retrieveCustomers(Proxy pxy);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomers(Proxy pxy);
	public boolean existCustomerId(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public Map<String, Object> fileUpload(Proxy pxy);
	public void removeCustomer(CustomerDTO cus);
	public Map<String,Object> retreivePhone(Proxy pxy);
	public CustomerDTO retreiveCustomerOne(CustomerDTO cus);
}

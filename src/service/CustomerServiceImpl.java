package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() { dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}
	CustomerDAO dao;


	@Override
	public void joinCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
		
	}

	@Override
	public List<CustomerDTO> bringCustomersList(Proxy pxy) {
		return dao.selectCustomersList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(Proxy pxy) {
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomers(Proxy pxy) {
		return dao.countCustomers(pxy);
	}

	@Override
	public boolean existCustomerId(CustomerDTO cus) {
		return dao.existCustomerId(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		dao.deleteCustomer(cus);
	}
	@Override
	public Map<String, Object> retreivePhone(Proxy pxy) {
		return dao.selectPhone(pxy);
	}
	@Override
	public CustomerDTO retreiveCustomerOne(CustomerDTO cus) {
		return dao.selectCustomerOne(cus);
	}
	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		return dao.selectProfile(pxy);
	}

}

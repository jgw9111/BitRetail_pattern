package service;

import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;

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
	public List<CustomerDTO> bringCustomersList() {
		return dao.selectCustomersList();
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(String searchWord) {
		return dao.selectCustomers(searchWord);
	}

	@Override
	public CustomerDTO retrieveCustomer(String searchWord) {
		return dao.selectCustomer(searchWord);
	}

	@Override
	public int countCustomers() {
		return dao.countCustomers();
	}

	@Override
	public boolean existCustomer(String searchWord) {
		return dao.existCustomer(searchWord);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		dao.deleteCustomer(cus);
	}

}

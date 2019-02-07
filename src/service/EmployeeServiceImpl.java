package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {dao = EmployeeDAOImpl.getInstance(); }
	public static EmployeeServiceImpl getInstance() {return instance;}
	EmployeeDAO dao;
	
	@Override
	public void registerEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> bringEmployeesList() {
		return dao.selectEmployeeList();
	}

	@Override
	public List<EmployeeDTO> retrieveEmployees(String searchWord) {
		return dao.selectEmployeeList();
		
	}

	@Override
	public EmployeeDTO retrieveEmployee(String serchWord) {
		return dao.selectEmployee(serchWord);
	}

	@Override
	public int countEmployees() {
		return dao.countEmployees();
	}

	@Override
	public boolean exsitEmployee(EmployeeDTO emp) {
		return dao.exsitEmployee(emp);
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {
		dao.updateEmployee(emp);
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		dao.deleteEmployee(emp);
	}

}

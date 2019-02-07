package dao;

import java.util.List;

import domain.EmployeeDTO;

public interface EmployeeDAO {
	
	public void insertEmployee(EmployeeDTO emp);
	public List<EmployeeDTO> selectEmployeeList();
	public List<EmployeeDTO> selectEmployees(String searchWord);
	public EmployeeDTO selectEmployee(String serchWord);
	public int countEmployees();
	public boolean exsitEmployee(EmployeeDTO emp);
	public void updateEmployee(EmployeeDTO emp);
	public void deleteEmployee(EmployeeDTO emp);
}

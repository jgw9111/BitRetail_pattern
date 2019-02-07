package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
		public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
			/*setAction(request.getParameter("cmd"));
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
			setPage(request.getParameter("page"));
			execute();*/
			/*Command move = new Command(request, response);*/
			super(request, response);
			
			switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case REGISTER: 
				EmployeeDTO emp = new EmployeeDTO();
				emp.setBirthDate(request.getParameter("birth_date"));
				emp.setManager(request.getParameter("manager"));
				emp.setName(request.getParameter("name"));
				emp.setNotes(request.getParameter("desc"));
				emp.setPhoto(request.getParameter("photo"));
				EmployeeServiceImpl.getInstance().registerEmployee(emp);
				break;
			case SIGNUP:
				CustomerDTO cus = new CustomerDTO();
				cus.setAddress(request.getParameter("address"));
				cus.setCity(request.getParameter("city"));
				cus.setCustomerID(request.getParameter("customerID"));
				cus.setCustomerName(request.getParameter("customerName"));
				cus.setPassword(request.getParameter("password"));
				cus.setPostalCode(request.getParameter("postalCode"));
				cus.setSsn(request.getParameter("ssn"));
				CustomerServiceImpl.getInstance().joinCustomer(cus);
				break;
			}
		}
}

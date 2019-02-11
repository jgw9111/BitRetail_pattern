package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		HttpSession session = request.getSession();
		System.out.println("===existCommand 진입===");
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = 
			EmployeeServiceImpl.getInstance().exsitEmployee(emp);
			if(exist) {
				System.out.println("접근 가능");
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomersList();
				System.out.println("총 고객의 수: "+list.size());
				System.out.println("가장 최근에 가입한 고객명 : "+list.get(0).getCustomerName());
				request.setAttribute("list",list);
			}else {
				System.out.println("접근 불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		case SIGNIN: 
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(request.getParameter("customerID"));
			cus.setPassword(request.getParameter("password"));
			System.out.println("ID ::"+request.getParameter("customerID"));
			System.out.println("pw ::"+request.getParameter("password"));
			cus =
			CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			if(cus != null) {
				System.out.println("접근 가능");
				session.setAttribute("customer",cus);
			}else {
				System.out.println("접근 불가");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
				
			}
			break;
		default:
			break;
		}
		
		
		
		System.out.println("Existcommand: "+super.getView());
	}
}

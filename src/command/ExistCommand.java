package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		System.out.println("===existCommand 진입===");
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmployeeId(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		boolean exist = 
		EmployeeServiceImpl.getInstance().exsitEmployee(emp);
		if(exist) {
			System.out.println("접근 가능");
		}else {
			System.out.println("접근 불가");
			super.setDomain("home");
			super.setPage("main");
			super.execute();
		}
		System.out.println("Existcommand: "+super.getView());
	}
}

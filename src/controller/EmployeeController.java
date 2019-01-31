package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.EmployeeDTO;
import enums.Action;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService service = EmployeeServiceImpl.getInstance();   
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== 1  컨트롤러 진입 ===");
		Receiver.init(request, response); // view 세팅
		/*String action = Receiver.cmd.getAction();*/
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("==무브진입==");
			Carrier.forward(request, response);
			break;
			
		case REGISTER:
			System.out.println("==레지스터진입==");
			EmployeeDTO emp = new EmployeeDTO();
			emp.setBirthDate(request.getParameter("birth_date"));
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setNotes(request.getParameter("desc"));
			emp.setPhoto(request.getParameter("photo"));
			service.registerEmployee(emp);
			Carrier.forward(request, response);
			break;
		}
	}
}
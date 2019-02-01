package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
		public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
			/*setAction(request.getParameter("cmd"));
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
			setPage(request.getParameter("page"));
			execute();*/
			/*Command move = new Command(request, response);*/
			super(request, response);
			EmployeeDTO emp = new EmployeeDTO();
			emp.setBirthDate(request.getParameter("birth_date"));
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setNotes(request.getParameter("desc"));
			emp.setPhoto(request.getParameter("photo"));
			EmployeeServiceImpl.getInstance().registerEmployee(emp);
		}
}

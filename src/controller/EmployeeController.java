package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== 1  컨트롤러 진입 ===");
		Receiver.init(request, response); // view 세팅
		/*String action = Receiver.cmd.getAction();*/
		switch (Action.valueOf(Receiver
				.cmd
				.getAction()
				.toUpperCase())) {
		case MOVE:
			System.out.println("==무브진입==");
			Carrier.forward(request, response);
			break;
			
		case REGISTER:

			Carrier.forward(request, response);
			break;
		}
	}
}
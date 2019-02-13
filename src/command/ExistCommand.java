package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagenation;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();	
		
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
				System.out.println("사원 접근 허용 ::"+exist);
				Proxy paging = new Pagenation();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				System.out.println("페이지 넘버::"+request.getParameter("page_num"));
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomersList(pagePxy);
				request.setAttribute("list",list);
				System.out.println("총 고객수::"+list.size());
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

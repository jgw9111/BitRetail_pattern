package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import enums.Action;
import proxy.Pagenation;
import proxy.Proxy;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	//sysout cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		System.out.println("===list커맨드 진입===");
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_LIST:
			System.out.println("==list-cmd=="+request.getParameter("cmd"));
			System.out.println("==list-page=="+request.getParameter("page"));
			System.out.println("==list-page_num=="+request.getParameter("page_num"));
			System.out.println("==list-page_size=="+request.getParameter("page_size"));

			List<CustomerDTO> list = CustomerServiceImpl
								.getInstance()
								.bringCustomersList(new Proxy().getPage());
			request.setAttribute("list",list);
			
			break;
		default:
			break;
		}
		
	}
}

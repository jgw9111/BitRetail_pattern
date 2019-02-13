package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagenation;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	//sysout cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		PageProxy pagePxy = new PageProxy();
		Pagenation page = new Pagenation();
		pagePxy.carryOut(pxy);
		page.carryOut(pxy);
		
		System.out.println("===list커맨드 진입===");
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_LIST:
			System.out.println("==list-cmd=="+request.getParameter("cmd"));
			System.out.println("==list-page=="+request.getParameter("page"));
			System.out.println("==list-page_num=="+request.getParameter("page_num"));
			System.out.println("==list-page_size=="+request.getParameter("page_size"));

			List<CustomerDTO> list = CustomerServiceImpl
								.getInstance()
								.bringCustomersList(new PageProxy().getPage());
			request.setAttribute("list",list);
			
			break;
		default:
			break;
		}
		
	}
}

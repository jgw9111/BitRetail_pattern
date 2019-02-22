package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	//sysout cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		Proxy paging = new Pagination();
		paging.carryOut(request);
		Proxy pagePxy = new PageProxy();
		pagePxy.carryOut(paging);
		
		System.out.println("===list커맨드 진입===");
		String flag = request.getParameter("cmd").toUpperCase();
		List<?> list = new ArrayList<>();
		switch (Action.valueOf(flag)) {
		case CUST_LIST:
			System.out.println("==list-cmd=="+request.getParameter("cmd"));
			System.out.println("==list-page=="+request.getParameter("page"));
			System.out.println("==list-page_num=="+request.getParameter("page_num"));
			System.out.println("==list-page_size=="+request.getParameter("page_size"));
			list = CustomerServiceImpl
								.getInstance()
								.bringCustomersList(pagePxy);
			
			break;
		case CUST_PHONE:
			Map<String,Object> map = CustomerServiceImpl.getInstance().retreivePhone(null);
			request.setAttribute("map",map);
			break;
		case CATE_LIST:
			list = CategoryServiceImpl
			.getInstance()
			.bringCategoryLists(pagePxy);
			break;
		default:
			break;
		}
		request.setAttribute("list",list);
		request.setAttribute("pagenation", paging);
		
	}
}

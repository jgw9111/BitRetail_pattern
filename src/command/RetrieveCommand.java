package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RetrieveCommand extends Command {
	public RetrieveCommand(Map<String,Proxy> pxy){
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("===리트리브 커맨드 진입===");
		CustomerDTO cus = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		cus.setCustomerID(request.getParameter("customerID"));
		cus = CustomerServiceImpl.getInstance().retreiveCustomerOne(cus);
		/*img = CustomerServiceImpl.getInstance().fileUpload(pxy);*/
		request.setAttribute("cust",cus);
		request.setAttribute("img",img);
		}
	
}

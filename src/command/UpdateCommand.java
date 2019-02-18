package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		System.out.println("===update 커맨드진입===");
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customer_id = request.getParameter("customerID");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(customer_id);
		cus = CustomerServiceImpl.getInstance().retreiveCustomerOne(cus);
		System.out.println("수정하기전 회원의 정보: "+cus.toString());
		if(!request.getParameter("phone").equals("")) cus.setPhone(request.getParameter("phone"));
		/*String _phone = (request.getParameter("phone")==null) ? _phone : request.getParameter("phone"); */ //hidden
		if(!request.getParameter("city").equals("")) cus.setCity(request.getParameter("city"));
		if(!request.getParameter("address").equals("")) cus.setAddress(request.getParameter("address"));
		if(!request.getParameter("postalCode").equals("")) cus.setPostalCode(request.getParameter("postalCode"));
		if(!request.getParameter("password").equals("")) cus.setPassword(request.getParameter("password"));
		/*String city = (request.getParameter("city")==null) ? cus.getCity() : request.getParameter("city");
		String address = (request.getParameter("address")==null) ? cus.getAddress() : request.getParameter("address");
		String postalCode = (request.getParameter("postalCode")==null) ? cus.getPostalCode() : request.getParameter("postalCode");
		String password = (request.getParameter("password")==null) ? cus.getPassword() : request.getParameter("password");*/
		/*cus.setPhone(phone);
		cus.setCity(city);
		cus.setAddress(address);
		cus.setPostalCode(postalCode);
		cus.setPassword(password);*/
		System.out.println("수정하려는 회원의 정보: "+ cus.toString());
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
		request.setAttribute("cust", cus);
	}
}

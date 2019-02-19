package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ImageServiceImpl;

import com.oreilly.servlet.MultipartRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.Action;

public class FileCommand extends Command {
	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		System.out.println("====파일커맨드 진입====");
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD : 
			System.out.println("->>>파일커맨드 cust_file_upload");
			ImageProxy ipxy = new ImageProxy();
			ipxy.carryOut(request);
			ImageDTO image = ipxy.getImg();
			String customerID = ipxy.getImg().getOwner();
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(customerID);
			cust = CustomerServiceImpl.getInstance().retreiveCustomerOne(cust);
			request.setAttribute("image",image);
			request.setAttribute("cust",cust);
			break;
		default:
			break;
		}
		//java.lang.String saveDirectory, int maxPostSize, java.lang.String encoding, FileRenamePolicy policy
	}
}

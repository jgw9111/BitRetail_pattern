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
			Map<String,Object> map = CustomerServiceImpl
									.getInstance()
									.fileUpload(ipxy);
			// 1. 업로드한 이미지 insert 해야함
			// 2. customer 안 photo에 대표이미지(프로필사진)을 인서트한 이미지로 바꿔야한다
			// 		(단, default_photo.jpg 로 되어있는 것을 이미지의 seq 값으로 바꾼다.)
			// 3. 이후 고객의 정보 / 이미지에서 seq에 따른 이미지 정보 두개를 가져온다
			//
			System.out.println("--------------"+ipxy);
			request.setAttribute("image",map.get("img"));
			request.setAttribute("cust",map.get("cust"));
			break;
		default:
			break;
		}
		//java.lang.String saveDirectory, int maxPostSize, java.lang.String encoding, FileRenamePolicy policy
	}
}

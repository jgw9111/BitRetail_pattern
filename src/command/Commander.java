package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {
	public static Command order(Map<String,Proxy> pxy){
		System.out.println("=== 3  커맨더진입 ===");
		Command cmd = null;
		System.out.println("cmd :: "+cmd);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE: 
			cmd = new Command(pxy);
			break;
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS: case SIGNIN:
			cmd = new ExistCommand(pxy);
			break;
		case CUST_LIST: case CUST_PHONE:
			cmd = new ListCommand(pxy);
			break;
		default:
			break;
		}
		System.out.println("커맨더 내: "+Receiver.cmd.getView());
		return cmd;
	}
}

package command;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, page, view;
	public void execute() {
		System.out.println("=== 5  뷰 세팅 ===");
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
	
	

}
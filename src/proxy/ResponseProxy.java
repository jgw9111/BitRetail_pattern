package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class ResponseProxy implements Proxy {
	private HttpServletResponse response;
		
	@Override
	public void carryOut(Object o) {
		System.out.println("===4.리스폰스 프록시===");
		if((HttpServletResponse) o != null) {
			System.out.println("o가 null이 아님");
			setResponse((HttpServletResponse) o);
		}else {
			System.out.println("o가 null");
		}
	}
	
}

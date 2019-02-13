package proxy;

import lombok.Data;

@Data
public class PageProxy implements Proxy{
	private Pagenation page;
	
	@Override
	public void carryOut(Object o) {
		setPage((Pagenation) o); //다운캐스팅 처리 -> object 타입을 pagenation타입으로 형변환
	}

}

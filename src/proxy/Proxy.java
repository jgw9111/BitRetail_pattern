package proxy;

import lombok.Data;

@Data
public class Proxy implements Capable{
	private Pagenation page;
	public Proxy() {carryOut();}
	
	@Override
	public void carryOut() {
		this.page = new Pagenation();
		page.carryOut();
	}

}

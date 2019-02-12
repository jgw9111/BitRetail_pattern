package proxy;


import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagenation implements Capable{
	private String pageNum, count, pageSize, blockSize,
				   startRow,endRow, startPage, endPage,
				   prevBlock,nextBlock;
	private int totalCount;
	private boolean existPrev,existNext;
	
	@Override
	public void carryOut() {
		System.out.println("==페이지네이션==");
		HttpServletRequest req = Receiver.cmd.getRequest();
		String pageNum = req.getParameter("page_num");
		this.pageNum = (pageNum==null)? "1" :pageNum; 
		String pageSize = req.getParameter("page_size");
		this.pageSize = (pageSize==null)? "5" : pageSize ;
		this.totalCount = CustomerServiceImpl.getInstance().countCustomers();
		this.startRow = (totalCount - Integer.parseInt(this.pageSize))+"";
		this.endRow = (Integer.parseInt(this.startRow) -4) +"" ;
		
		
		System.out.println("TotalCount ::"+this.totalCount);
		System.out.println("startRow ::"+startRow);
		System.out.println("endRow ::"+endRow);
		System.out.println("pageNum ::"+this.pageNum);
		System.out.println("pageSize ::"+this.pageSize);
	}
}

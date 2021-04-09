package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import bean.BuyBook;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class FinRecordAction implements Action {	//查找所有记录

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//还书日期为空表示没有归还图书
		HttpSession session=req.getSession();
		String URL=null;
		if(req.getParameter("findURL").equals("borrowRecord.jsp")) {
			BorrrecordDao bRecord=new BorrrecordDaoImpl();
			List<Borrrecord> list=bRecord.findRecordByBorrower();
			session.setAttribute("RecordList", list);
			System.out.println(list.get(0).getBorrowerId());
			System.out.println("图书名:"+list.get(0).getBookName());
			URL="borrowRecord.jsp";
		}else if(req.getParameter("findURL").equals("buyBook.jsp")) {
			//查询购书清单
			BuyBookDao buyDao=new BuyBookDaoImpl();
			List<BuyBook> buyList=buyDao.findAllBuyBook();
			session.setAttribute("buyList", buyList);
			URL="buyBook.jsp";
		}else if(req.getParameter("findURL").equals("orderhistory.jsp")) {
			BorrrecordDao bRecord=new BorrrecordDaoImpl();
			List<Borrrecord> list=bRecord.findRecordByBorrower();
			session.setAttribute("RecordList", list);
			System.out.println(list.get(0).getBorrowerId());
			System.out.println("图书名:"+list.get(0).getBookName());
			URL="orderhistory.jsp";
		}
		
		return URL;
	}
}

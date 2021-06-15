package action;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BuyBook;
import bean.Reserve;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.SelfDao;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class AddOrderAction implements Action {
	//实现用户预定图书工能

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	//添加一条预定记录
		ReserveDao reserveDao=new ReserveDaoImpl();
		Reserve reserve=new Reserve();
		SelfDao selfDao=new SelfDaoImpl();
		String bookName = null;
		try {
			bookName = new String(req.getParameter("bookname").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		reserve.setselfId(req.getParameter("selfId"));	//书架ID
		reserve.setBorowerId(req.getParameter("userid"));	//预定者id
		String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		reserve.setReserveTime(timeStr1);	//预定时间
		reserve.setBookName(bookName);
		
		System.out.println(timeStr1);
		System.out.println(reserve.getBookName());
		System.out.println(req.getParameter("selfId"));
		if(reserveDao.findReseRecord(reserve.getBorowerId(),req.getParameter("selfId")).size()>0) {
			req.setAttribute("error", "您已预定过该图书,请及时到馆取书!");
		}else {
			if (reserveDao.doReserve(reserve)) { //返回操作是否成功
				int bookNum = selfDao.findBookBySelfId(req.getParameter("selfId")).getBookNum()-1;
				selfDao.upBookNumber(req.getParameter("selfId"), bookNum);
				req.setAttribute("error", "预定成功");
			} else {
				req.setAttribute("error", "预定失败");
			}
		}
		return "AcatalogSearch.jsp";
	}
}

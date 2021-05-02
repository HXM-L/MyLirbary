package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BuyBook;
import bean.Reserve;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import framework.Action;

public class UpdateReserveAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	//修改一条预定记录
		ReserveDao reserveDao=new ReserveDaoImpl();
		Reserve reserve=new Reserve();
		String bookName = null;
		String fetchFlag=null;
		try {
			bookName = new String(req.getParameter("bookName").getBytes("iso-8859-1"), "utf-8");
			fetchFlag = new String(req.getParameter("status").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		reserve.setReserveid(Integer.parseInt(req.getParameter("reserveid")));
		reserve.setselfId(req.getParameter("selfId"));
		reserve.setBorowerId(req.getParameter("borowerId"));
		reserve.setReserveTime(req.getParameter("reserveTime"));
		reserve.setFetchTime(req.getParameter("fetchTime"));
		reserve.setStatus(fetchFlag);
		reserve.setBookName(bookName);
		System.out.println(reserve.getBookName());
		if (reserveDao.updateReserveById(reserve)) { //返回操作是否成功
			req.setAttribute("updateFlag", "更新成功");
			System.out.println(req.getAttribute("updateFlag"));
		} else {
			req.setAttribute("updateFlag", "更新失败");
		}
		return "orderhistory.jsp";
	}

}

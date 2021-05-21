package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import framework.Action;

public class DeleteAction implements Action {// 所有删除操作

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String URL=null;
		if (req.getParameter("AppointPage").equals("UpRecord")) {	//删除一条指定ID的借阅记录
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
			URL="borrowRecord.jsp";
		} else if (req.getParameter("AppointPage").equals("buyBook.jsp")) {	//删除一条指定ID的购书记录
			BuyBookDao buyBookDao=new BuyBookDaoImpl();
			if (buyBookDao.deleteBuyBook(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
			URL="buyBook.jsp";
		}else if (req.getParameter("AppointPage").equals("orderhistory.jsp")) {	//删除一条指定ID的预定记录
			ReserveDao reserveDao=new ReserveDaoImpl();
			if (reserveDao.deleteReserveRecord(Integer.parseInt(req.getParameter("rID")))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
			URL="orderhistory.jsp";
		}else if (req.getParameter("AppointPage").equals("Aorderhistory.jsp")) {	//删除一条指定ID的预定记录
			ReserveDao reserveDao=new ReserveDaoImpl();
			if (reserveDao.deleteReserveRecord(Integer.parseInt(req.getParameter("rID")))) {
				req.setAttribute("updateFlag", "取消成功");
			} else {
				req.setAttribute("updateFlag", "取消失败");
			}
			URL="Aorderhistory.jsp";
		}else if (req.getParameter("AppointPage").equals("urgeReturn")) {	//删除一条指定ID的借阅记录
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
			URL="urgeReturn.jsp";
		}

		return URL;
	}

}

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import bean.BuyBook;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class ReturnDialogAction implements Action { // 所有修改页面

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageURL = null;
		if (req.getParameter("AppointPage").equals("UpRecord")) { // 查找要修改借阅的记录
			BorrrecordDao brecordDao = new BorrrecordDaoImpl();
			Borrrecord brecord = null;
			System.out.println(req.getParameter("rID"));
			brecord = brecordDao.findRecordByBorrowerId(req.getParameter("rID"));
			System.out.println(brecord.getBookName());
			req.getSession().setAttribute("recoed", brecord);
			req.setAttribute("UFlag", "true");
			pageURL = "upbRecord.jsp";
		} else if (req.getParameter("AppointPage").equals("buyBook.jsp")) { // 查找要修改的购书清单记录
			System.out.println(req.getParameter("rID"));
			BuyBookDao buyBookDao=new BuyBookDaoImpl();
			BuyBook buyRecord=buyBookDao.findRecordByID(req.getParameter("rID"));
			System.out.println(buyRecord.getBookName());
			req.getSession().setAttribute("buyRecord", buyRecord);
			req.setAttribute("UFlag", "true");
			pageURL = "upbuyBook.jsp";
		}
		return pageURL;
	}

}

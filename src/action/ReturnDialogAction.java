package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class ReturnDialogAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageURL=null;
		BorrrecordDao brecordDao=new BorrrecordDaoImpl();
		Borrrecord brecord=null;
		if(req.getParameter("AppointPage").equals("UpRecord")) {
			System.out.println(req.getParameter("rID"));
			brecord=brecordDao.findRecordByBorrowerId(req.getParameter("rID"));
			System.out.println(brecord.getBookName());
			req.getSession().setAttribute("recoed", brecord);
			req.setAttribute("UFlag", true);
			pageURL= "borrowRecord.jsp";
		}
		return pageURL;
	}

}

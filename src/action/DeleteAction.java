package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class DeleteAction implements Action {// 所有删除操作

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		if (req.getParameter("AppointPage").equals("UpRecord")) {	//删除一条指定ID的借阅记录
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
		} else if (req.getParameter("AppointPage").equals("buyBook.jsp")) {	//删除一条指定ID的购书记录
			BuyBookDao buyBookDao=new BuyBookDaoImpl();
			if (buyBookDao.deleteBuyBook(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "删除成功");
			} else {
				req.setAttribute("updateFlag", "删除失败");
			}
		}

		System.out.println("kkkkk");
		return "buyBook.jsp";
	}

}

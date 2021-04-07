package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class DeleteAction implements Action {//ËùÓÐÉ¾³ý²Ù×÷

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		BorrrecordDao BRecord = new BorrrecordDaoImpl();
		if (req.getParameter("AppointPage").equals("UpRecord")) {
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "É¾³ý³É¹¦");
			} else {
				req.setAttribute("updateFlag", "É¾³ýÊ§°Ü");
			}
		}

		System.out.println("kkkkk");
		return "borrowRecord.jsp";
	}

}

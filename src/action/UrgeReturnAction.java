package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class UrgeReturnAction implements Action {

	BorrrecordDao brdao = new BorrrecordDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 需要获得用户id
		String borrowerId = req.getParameter("bid");
		List<Borrrecord> lb = null;
		lb = brdao.findOvertimeByBorrowerId(borrowerId);//催还图书
		if (lb.size() > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("lb", lb);
			return "";
		} else {
			req.setAttribute("str", "催还图书记录为空！");
			return "";
		}
	}

}

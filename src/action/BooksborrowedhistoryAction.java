package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class BooksborrowedhistoryAction implements Action {

	BorrrecordDao brdao = new BorrrecordDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 需要获得用户id
		String borrowerId = req.getParameter("bid");
		List<Borrrecord> lb = null;
		return borrowerId;
		
	}

}

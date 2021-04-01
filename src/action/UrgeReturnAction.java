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
		// ��Ҫ����û�id
		String borrowerId = req.getParameter("bid");
		List<Borrrecord> lb = null;
		lb = brdao.findOvertimeByBorrowerId(borrowerId);//�߻�ͼ��
		if (lb.size() > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("lb", lb);
			return "";
		} else {
			req.setAttribute("str", "�߻�ͼ���¼Ϊ�գ�");
			return "";
		}
	}

}

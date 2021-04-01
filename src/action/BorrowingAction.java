package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class BorrowingAction implements Action {

	BorrrecordDao brdao = new BorrrecordDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//��Ҫ����û�id,�鱾bookid
		String borrowerId = req.getParameter("bid");
		String bookid = req.getParameter("bookid");
		Borrrecord b = brdao.findBorrrecord(borrowerId, bookid);
		String returnTime  = b.getReturnTime();
		List<Borrrecord> lb = null;
		lb = brdao.findNowRecordByBorrowerId(borrowerId);//��ǰ����
		boolean isFlag = brdao.updateBorrrecordByBorrowerId(borrowerId, bookid, returnTime);
		if(lb.size()>0 ) {
			HttpSession session = req.getSession();
			session.setAttribute("lb", lb);
			session.setAttribute("aginFlag", isFlag);//����ɹ�
			return "";
		}else {
			req.setAttribute("str", "��ǰ��δ���飡");
			return "";
		}
	}

}

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class DeleteAction implements Action {//����ɾ������

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		BorrrecordDao BRecord = new BorrrecordDaoImpl();
		if (req.getParameter("AppointPage").equals("UpRecord")) {
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
		}

		System.out.println("kkkkk");
		return "borrowRecord.jsp";
	}

}

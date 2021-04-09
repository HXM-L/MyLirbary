package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class DeleteAction implements Action {// ����ɾ������

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		if (req.getParameter("AppointPage").equals("UpRecord")) {	//ɾ��һ��ָ��ID�Ľ��ļ�¼
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
		} else if (req.getParameter("AppointPage").equals("buyBook.jsp")) {	//ɾ��һ��ָ��ID�Ĺ����¼
			BuyBookDao buyBookDao=new BuyBookDaoImpl();
			if (buyBookDao.deleteBuyBook(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
		}

		System.out.println("kkkkk");
		return "buyBook.jsp";
	}

}

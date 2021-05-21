package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import framework.Action;

public class DeleteAction implements Action {// ����ɾ������

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String URL=null;
		if (req.getParameter("AppointPage").equals("UpRecord")) {	//ɾ��һ��ָ��ID�Ľ��ļ�¼
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
			URL="borrowRecord.jsp";
		} else if (req.getParameter("AppointPage").equals("buyBook.jsp")) {	//ɾ��һ��ָ��ID�Ĺ����¼
			BuyBookDao buyBookDao=new BuyBookDaoImpl();
			if (buyBookDao.deleteBuyBook(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
			URL="buyBook.jsp";
		}else if (req.getParameter("AppointPage").equals("orderhistory.jsp")) {	//ɾ��һ��ָ��ID��Ԥ����¼
			ReserveDao reserveDao=new ReserveDaoImpl();
			if (reserveDao.deleteReserveRecord(Integer.parseInt(req.getParameter("rID")))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
			URL="orderhistory.jsp";
		}else if (req.getParameter("AppointPage").equals("Aorderhistory.jsp")) {	//ɾ��һ��ָ��ID��Ԥ����¼
			ReserveDao reserveDao=new ReserveDaoImpl();
			if (reserveDao.deleteReserveRecord(Integer.parseInt(req.getParameter("rID")))) {
				req.setAttribute("updateFlag", "ȡ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ȡ��ʧ��");
			}
			URL="Aorderhistory.jsp";
		}else if (req.getParameter("AppointPage").equals("urgeReturn")) {	//ɾ��һ��ָ��ID�Ľ��ļ�¼
			BorrrecordDao BRecord = new BorrrecordDaoImpl();
			if (BRecord.deleteRecord(req.getParameter("rID"))) {
				req.setAttribute("updateFlag", "ɾ���ɹ�");
			} else {
				req.setAttribute("updateFlag", "ɾ��ʧ��");
			}
			URL="urgeReturn.jsp";
		}

		return URL;
	}

}

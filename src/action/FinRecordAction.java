package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrower;
import bean.Borrrecord;
import bean.BuyBook;
import bean.Reserve;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import framework.Action;

public class FinRecordAction implements Action { // �������м�¼

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// ��������Ϊ�ձ�ʾû�й黹ͼ��
		HttpSession session = req.getSession();

		String URL = null;
		if (req.getParameter("findURL").equals("borrowRecord.jsp")) { // ��ѯ���н��ļ�¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> list = bRecord.findAllRecords();
			if(list.size()>0) {
				session.setAttribute("RecordList", list);
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
			
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("ͼ����:" + list.get(0).getBookName());
			URL = "borrowRecord.jsp";
		} else if (req.getParameter("findURL").equals("buyBook.jsp")) {// ��ѯ�����嵥
			BuyBookDao buyDao = new BuyBookDaoImpl();
			List<BuyBook> buyList = buyDao.findAllBuyBook();
			if(buyList.size()>0) {
				session.setAttribute("buyList", buyList);
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
			session.setAttribute("buyList", buyList);
			URL = "buyBook.jsp";
		} else if (req.getParameter("findURL").equals("orderhistory.jsp")) { // ԤԼͼ���¼
			ReserveDao reserDao = new ReserveDaoImpl();
			List<Reserve> reserveList = reserDao.findReseRecord();
			if(reserveList.size()>0) {
				session.setAttribute("reserveList", reserveList);
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
			URL = "orderhistory.jsp";
		}else if (req.getParameter("findURL").equals("borrowing.jsp")) { // ��ǰ���ļ�¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> borrowinglist = bRecord.findBorrowIng();
			if(borrowinglist.size()>0) {
				session.setAttribute("borrowinglist", borrowinglist);
				System.out.println(borrowinglist.get(0).getBookName());
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
			for(Borrrecord item:borrowinglist) {
				System.out.println(item.getBorrRecordId());
			}
//			System.out.println("ͼ����:" + borrowinglist.get(0).getBookName());
			URL = "borrowing.jsp";
		}else if (req.getParameter("findURL").equals("Aborrowing.jsp")) { // ��ǰ���ļ�¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> borrowinglist = bRecord.findNowRecordByBorrowerId(borrower.getBorrowerId());
			if(borrowinglist.size()>0) {
				session.setAttribute("borrowinglist", borrowinglist);
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
//			System.out.println("ͼ����:" + borrowinglist.get(0).getBookName());
			URL = "Aborrowing.jsp";
		}else if (req.getParameter("findURL").equals("urgeReturn.jsp")) { // ����Ա��Ҫ�����û��߻�ͼ���¼��¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> list = bRecord.findUrge();
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ�գ�");
			}
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("ͼ����:" + list.get(0).getBookName());
			URL = "urgeReturn.jsp";
		}else if (req.getParameter("findURL").equals("Aorderhistory.jsp")) { //��ѯָ���û���Ԥ����¼
			ReserveDao reserDao = new ReserveDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Reserve> reserveList = reserDao.findReseRecord(borrower.getBorrowerId());
			if(reserveList.size()>0) {
				session.setAttribute("reserveList", reserveList);
			}else {
				req.setAttribute("updateFlag", "��Ŀǰû��Ԥ���鼮��");
			}
			URL = "Aorderhistory.jsp";
		}else if (req.getParameter("findURL").equals("AurgeReturn.jsp")) { // ��Ҫָ���û��߻�ͼ���¼��¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> list = bRecord.findRecordByBorrower(borrower.getBorrowerId());
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
				req.setAttribute("updateFlag", "�뼰ʱ�黹����ͼ�飡");
			}else {
				req.setAttribute("updateFlag", "��û�г���δ��ͼ��,����������������ã�");
			}
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("ͼ����:" + list.get(0).getBookName());
			URL = "AurgeReturn.jsp";
		}else if (req.getParameter("findURL").equals("Abooksborrowedhistory.jsp")) { // ��Ҫָ���û�����ͼ����ļ�¼
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> list = bRecord.findAllRecords(borrower.getBorrowerId());
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
//				req.setAttribute("updateFlag", "�뼰ʱ�黹����ͼ�飡");
			}else {
				req.setAttribute("updateFlag", "��¼Ϊ��");
			}
			URL = "Abooksborrowedhistory.jsp";
		}
		return URL;
	}
}

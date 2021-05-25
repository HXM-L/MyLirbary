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

public class FinRecordAction implements Action { // 查找所有记录

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 还书日期为空表示没有归还图书
		HttpSession session = req.getSession();

		String URL = null;
		if (req.getParameter("findURL").equals("borrowRecord.jsp")) { // 查询所有借阅记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> list = bRecord.findAllRecords();
			if(list.size()>0) {
				session.setAttribute("RecordList", list);
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
			
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("图书名:" + list.get(0).getBookName());
			URL = "borrowRecord.jsp";
		} else if (req.getParameter("findURL").equals("buyBook.jsp")) {// 查询购书清单
			BuyBookDao buyDao = new BuyBookDaoImpl();
			List<BuyBook> buyList = buyDao.findAllBuyBook();
			if(buyList.size()>0) {
				session.setAttribute("buyList", buyList);
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
			session.setAttribute("buyList", buyList);
			URL = "buyBook.jsp";
		} else if (req.getParameter("findURL").equals("orderhistory.jsp")) { // 预约图书记录
			ReserveDao reserDao = new ReserveDaoImpl();
			List<Reserve> reserveList = reserDao.findReseRecord();
			if(reserveList.size()>0) {
				session.setAttribute("reserveList", reserveList);
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
			URL = "orderhistory.jsp";
		}else if (req.getParameter("findURL").equals("borrowing.jsp")) { // 当前借阅记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> borrowinglist = bRecord.findBorrowIng();
			if(borrowinglist.size()>0) {
				session.setAttribute("borrowinglist", borrowinglist);
				System.out.println(borrowinglist.get(0).getBookName());
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
			for(Borrrecord item:borrowinglist) {
				System.out.println(item.getBorrRecordId());
			}
//			System.out.println("图书名:" + borrowinglist.get(0).getBookName());
			URL = "borrowing.jsp";
		}else if (req.getParameter("findURL").equals("Aborrowing.jsp")) { // 当前借阅记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> borrowinglist = bRecord.findNowRecordByBorrowerId(borrower.getBorrowerId());
			if(borrowinglist.size()>0) {
				session.setAttribute("borrowinglist", borrowinglist);
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
//			System.out.println("图书名:" + borrowinglist.get(0).getBookName());
			URL = "Aborrowing.jsp";
		}else if (req.getParameter("findURL").equals("urgeReturn.jsp")) { // 管理员需要所有用户催还图书记录记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			List<Borrrecord> list = bRecord.findUrge();
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
			}else {
				req.setAttribute("updateFlag", "记录为空！");
			}
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("图书名:" + list.get(0).getBookName());
			URL = "urgeReturn.jsp";
		}else if (req.getParameter("findURL").equals("Aorderhistory.jsp")) { //查询指定用户的预定记录
			ReserveDao reserDao = new ReserveDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Reserve> reserveList = reserDao.findReseRecord(borrower.getBorrowerId());
			if(reserveList.size()>0) {
				session.setAttribute("reserveList", reserveList);
			}else {
				req.setAttribute("updateFlag", "您目前没有预定书籍。");
			}
			URL = "Aorderhistory.jsp";
		}else if (req.getParameter("findURL").equals("AurgeReturn.jsp")) { // 需要指定用户催还图书记录记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> list = bRecord.findRecordByBorrower(borrower.getBorrowerId());
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
				req.setAttribute("updateFlag", "请及时归还超期图书！");
			}else {
				req.setAttribute("updateFlag", "您没有超期未还图书,请继续保持良好信用！");
			}
//			System.out.println(list.get(0).getBorrowerId());
//			System.out.println("图书名:" + list.get(0).getBookName());
			URL = "AurgeReturn.jsp";
		}else if (req.getParameter("findURL").equals("Abooksborrowedhistory.jsp")) { // 需要指定用户所有图书借阅记录
			BorrrecordDao bRecord = new BorrrecordDaoImpl();
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			List<Borrrecord> list = bRecord.findAllRecords(borrower.getBorrowerId());
			if(list.size()>0) {
				session.setAttribute("UrgeList", list);
//				req.setAttribute("updateFlag", "请及时归还超期图书！");
			}else {
				req.setAttribute("updateFlag", "记录为空");
			}
			URL = "Abooksborrowedhistory.jsp";
		}
		return URL;
	}
}

package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import bean.BuyBook;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class FinRecordAction implements Action {	//�������м�¼

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//��������Ϊ�ձ�ʾû�й黹ͼ��
		HttpSession session=req.getSession();
		String URL=null;
		if(req.getParameter("findURL").equals("borrowRecord.jsp")) {
			BorrrecordDao bRecord=new BorrrecordDaoImpl();
			List<Borrrecord> list=bRecord.findRecordByBorrower();
			session.setAttribute("RecordList", list);
			System.out.println(list.get(0).getBorrowerId());
			System.out.println("ͼ����:"+list.get(0).getBookName());
			URL="borrowRecord.jsp";
		}else if(req.getParameter("findURL").equals("buyBook.jsp")) {
			//��ѯ�����嵥
			BuyBookDao buyDao=new BuyBookDaoImpl();
			List<BuyBook> buyList=buyDao.findAllBuyBook();
			session.setAttribute("buyList", buyList);
			URL="buyBook.jsp";
		}else if(req.getParameter("findURL").equals("orderhistory.jsp")) {
			BorrrecordDao bRecord=new BorrrecordDaoImpl();
			List<Borrrecord> list=bRecord.findRecordByBorrower();
			session.setAttribute("RecordList", list);
			System.out.println(list.get(0).getBorrowerId());
			System.out.println("ͼ����:"+list.get(0).getBookName());
			URL="orderhistory.jsp";
		}
		
		return URL;
	}
}

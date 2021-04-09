package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrrecord;
import bean.BuyBook;
import dao.BorrrecordDao;
import dao.BuyBookDao;
import dao.impl.BorrrecordDaoImpl;
import dao.impl.BuyBookDaoImpl;
import framework.Action;

public class UpdateBuyRecordAction implements Action {	//�޸�һ�������¼

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		BuyBookDao buyBookDao=new BuyBookDaoImpl();
		BuyBook buyBook=new BuyBook();
		String bookName = null;
		try {
			bookName = new String(req.getParameter("bookName").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		buyBook.setBookName(bookName);
		buyBook.setBuyBookId(req.getParameter("buyBookId"));
		buyBook.setPrice(Double.parseDouble(req.getParameter("price")));
		buyBook.setNum(Integer.parseInt(req.getParameter("num")));
		buyBook.setSelfId(req.getParameter("selfId"));
		buyBook.setBuyDate(req.getParameter("buyDate"));
		buyBook.setSum(Double.parseDouble(req.getParameter("sum")));
		System.out.println(buyBook.getSum());
		if (buyBookDao.modifyBuyBook(buyBook)) { //���ز����Ƿ�ɹ�
			req.setAttribute("updateFlag", "���³ɹ�");
			System.out.println(req.getAttribute("updateFlag"));
		} else {
			req.setAttribute("updateFlag", "����ʧ��");
		}
		return "buyBook.jsp";
	}

}

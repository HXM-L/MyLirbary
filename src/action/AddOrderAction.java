package action;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BuyBook;
import bean.Reserve;
import dao.BuyBookDao;
import dao.ReserveDao;
import dao.SelfDao;
import dao.impl.BuyBookDaoImpl;
import dao.impl.ReserveDaoImpl;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class AddOrderAction implements Action {
	//ʵ���û�Ԥ��ͼ�鹤��

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	//���һ��Ԥ����¼
		ReserveDao reserveDao=new ReserveDaoImpl();
		Reserve reserve=new Reserve();
		SelfDao selfDao=new SelfDaoImpl();
		String bookName = null;
		try {
			bookName = new String(req.getParameter("bookname").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		reserve.setselfId(req.getParameter("selfId"));	//���ID
		reserve.setBorowerId(req.getParameter("userid"));	//Ԥ����id
		String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		reserve.setReserveTime(timeStr1);	//Ԥ��ʱ��
		reserve.setBookName(bookName);
		
		System.out.println(timeStr1);
		System.out.println(reserve.getBookName());
		System.out.println(req.getParameter("selfId"));
		if(reserveDao.findReseRecord(reserve.getBorowerId(),req.getParameter("selfId")).size()>0) {
			req.setAttribute("error", "����Ԥ������ͼ��,�뼰ʱ����ȡ��!");
		}else {
			if (reserveDao.doReserve(reserve)) { //���ز����Ƿ�ɹ�
				int bookNum = selfDao.findBookBySelfId(req.getParameter("selfId")).getBookNum()-1;
				selfDao.upBookNumber(req.getParameter("selfId"), bookNum);
				req.setAttribute("error", "Ԥ���ɹ�");
			} else {
				req.setAttribute("error", "Ԥ��ʧ��");
			}
		}
		return "AcatalogSearch.jsp";
	}
}

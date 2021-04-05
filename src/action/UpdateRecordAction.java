package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrrecord;
import dao.AdminDao;
import dao.BorrrecordDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class UpdateRecordAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) { // ���½��ļ�¼
		BorrrecordDao recordDao = new BorrrecordDaoImpl();
		Borrrecord brecord=new Borrrecord();
		String bookName = null;
		String againFlag=null;
		String overFlag=null;
		try {
			bookName = new String(req.getParameter("bookName").getBytes("iso-8859-1"), "utf-8");
			againFlag = new String(req.getParameter("aginBorr").getBytes("iso-8859-1"), "utf-8");
			overFlag = new String(req.getParameter("overTime").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(req.getParameter("returnTime").equals("")) {
			brecord.setReturnFlag("��");
		}else {
			brecord.setReturnFlag("��");
		}
		brecord.setBorrRecordId(req.getParameter("recordID"));
		brecord.setAginBorr(againFlag);
		brecord.setBookid(req.getParameter("bookID"));
		brecord.setBookName(bookName);
		brecord.setBorrowerId(req.getParameter("borrowerId"));
		brecord.setBorrTime(req.getParameter("borrTime"));
		brecord.setOverTime(overFlag);
		brecord.setReturnTime(req.getParameter("returnTime"));
		
		System.out.println(bookName);
		if (recordDao.updateRecordByRID(brecord)) { //���ز����Ƿ�ɹ�
			req.setAttribute("updateFlag", "���³ɹ�");
			System.out.println(req.getAttribute("updateFlag"));
		} else {
			req.setAttribute("updateFlag", "����ʧ��");
		}
		return "borrowRecord.jsp";
	}

}

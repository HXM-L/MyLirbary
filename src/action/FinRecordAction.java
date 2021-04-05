package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Borrrecord;
import dao.BorrrecordDao;
import dao.impl.BorrrecordDaoImpl;
import framework.Action;

public class FinRecordAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//还书日期为空表示没有归还图书
		HttpSession session=req.getSession();
		BorrrecordDao bRecord=new BorrrecordDaoImpl();
		List<Borrrecord> list=bRecord.findRecordByBorrower();
		session.setAttribute("RecordList", list);
		System.out.println(list.get(0).getBorrowerId());
		System.out.println("图书名:"+list.get(0).getBookName());
		System.out.println("图书名:"+list.get(1).getBookName());
		return "borrowRecord.jsp";
	}
}

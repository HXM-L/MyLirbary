package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Self;
import dao.SelfDao;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class SearchbookAction implements Action {

	SelfDao sdao = new SelfDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Self> ls =null;
		int typeid = 0;
		String bookname = null;
		String publisher = null;
		String author = null;

		String c = req.getParameter("ѡ�����ʲô��ѯ�Ǹ�����name");
		switch(c) {
		case "ͼ������":
			String booktypeid = req.getParameter("��д���name");
			typeid = Integer.parseInt(booktypeid);
			break;
		case "ͼ������":
			bookname=req.getParameter("��д���name");
			break;
		case "������":
			author=req.getParameter("��д���name");
			break;
		case "����������":
			publisher=req.getParameter("��д���name");
			break;
		}
		
		ls = sdao.findBookBybookTypeId(typeid, bookname, publisher, author);
		if(ls.size()>0) {
			req.setAttribute("List<Self>", ls);
			return "";
		}else {
			req.setAttribute("str", "��ѯ���Ϊ�գ�");
			return "";
		}
	}

}

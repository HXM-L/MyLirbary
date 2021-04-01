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

		String c = req.getParameter("选择根据什么查询那个框框的name");
		switch(c) {
		case "图书类型":
			String booktypeid = req.getParameter("填写框的name");
			typeid = Integer.parseInt(booktypeid);
			break;
		case "图书名称":
			bookname=req.getParameter("填写框的name");
			break;
		case "作者名":
			author=req.getParameter("填写框的name");
			break;
		case "出版社名称":
			publisher=req.getParameter("填写框的name");
			break;
		}
		
		ls = sdao.findBookBybookTypeId(typeid, bookname, publisher, author);
		if(ls.size()>0) {
			req.setAttribute("List<Self>", ls);
			return "";
		}else {
			req.setAttribute("str", "查询结果为空！");
			return "";
		}
	}

}

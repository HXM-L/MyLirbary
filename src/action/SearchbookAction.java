package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookType;
import bean.Self;
import dao.BookTypeDao;
import dao.SelfDao;
import dao.impl.BookTypeDaoImpl;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class SearchbookAction implements Action {

	String URL=null;
	SelfDao sdao = new SelfDaoImpl();
	BookTypeDao btDao=new BookTypeDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		List<Self> ls =null;
		int typeid=0;
		String bookname = null;
		String publisher = null;
		String author = null;
		String keyword=null;
		String c=req.getParameter("condition");
		try {
			keyword = new String(req.getParameter("keyword").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(keyword);
		System.out.println(req.getParameter("condition"));
		switch(c) {
		case "bookType":
			BookType btype=btDao.findBookTypeByTyprid(keyword);
			typeid=btype.getTypeId();
			break;
		case "bookName":
			bookname=keyword;
			break;
		case "author":
			author=keyword;
			break;
		case "pusher":
			publisher=keyword;
			break;
		}
		ls = sdao.findBookBybookTypeId(typeid, bookname, publisher, author);
		if(ls.size()>0) {
			System.out.println(ls.get(0).getBookname());
			req.setAttribute("searchList", ls);
			URL="AcatalogSearch.jsp";
		}else {
			req.setAttribute("error", "查询结果为空！");
			URL="AcatalogSearch.jsp";
		}
		return URL;
	}

}

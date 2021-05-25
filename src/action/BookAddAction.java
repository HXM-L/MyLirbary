package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Self;
import dao.SelfDao;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class BookAddAction implements Action {	//添加图书

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session=req.getSession();
		SelfDao selfDao=new SelfDaoImpl();
		session.setAttribute("isFlag", false);
		Self self=new Self();
		try {
			String bookid=req.getParameter("bookid");
			String type = new String(req.getParameter("type").getBytes("iso-8859-1"), "utf-8");
			String bookName = new String(req.getParameter("bookName").getBytes("iso-8859-1"), "utf-8");
			String author = new String(req.getParameter("author").getBytes("iso-8859-1"), "utf-8");
			String pubDate = new String(req.getParameter("publishDate").getBytes("iso-8859-1"), "utf-8");
			int num = Integer.parseInt(req.getParameter("number"));
			String introd = new String(req.getParameter("introd").getBytes("iso-8859-1"), "utf-8");
			String picture = "F:";
			String publisher = new String(req.getParameter("publish").getBytes("iso-8859-1"), "utf-8");
			
			self.setSelfId(bookid);
			self.setBookname(bookName);
			self.setAuthor(author);
			self.setPublisherDate(pubDate);
			self.setBookNum(num);
			self.setTypeId(Integer.parseInt(type));
			self.setPicture(picture);
			self.setIntroduction(introd);
			self.setPublisher(publisher);
			if(selfDao.doSelf(self)) {
				req.setAttribute("updateFlag", "添加成功");
			}else {
				req.setAttribute("updateFlag", "添加失败");
			}
			System.out.println(bookName);
			System.out.println(type);
			System.out.println(bookid);
			System.out.println(req.getParameter("number"));
			System.out.println(req.getSession().getAttribute("isFlag"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		return "editBooks.jsp";
	}

}

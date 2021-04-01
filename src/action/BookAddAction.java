package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Self;
import dao.SelfDao;
import dao.impl.SelfDaoImpl;
import framework.Action;

public class BookAddAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session=req.getSession();
		SelfDao selfDao=new SelfDaoImpl();
		session.setAttribute("isFlag", false);
		Self self=new Self();
		try {
			int typeid=1;
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
			if(type.equals("文学类")) {
				typeid=1;
			}else if(type.equals("数理科学类")) {
				typeid=2;
			}else if(type.equals("艺术类")) {
				typeid=3;
			}else if(type.equals("经济类")) {
				typeid=4;
			}else if(type.equals("军事类")) {
				typeid=5;
			}
			self.setTypeId(typeid);
			self.setPicture(picture);
			self.setIntroduction(introd);
			self.setPublisher(publisher);
			if(selfDao.doSelf(self)) {
				session.setAttribute("isFlag", true);
			}else {
				
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

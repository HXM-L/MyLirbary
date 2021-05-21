package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.BookType;
import bean.Borrower;
import bean.BuyBook;
import bean.Identity;
import dao.AdminDao;
import dao.BookTypeDao;
import dao.BorrowerDao;
import dao.BuyBookDao;
import dao.IdentityDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BookTypeDaoImpl;
import dao.impl.BorrowerDaoImpl;
import dao.impl.BuyBookDaoImpl;
import dao.impl.IdentityDaoImpl;
import framework.Action;

public class LoginAction implements Action {	//登录操作

	AdminDao adminDao=new AdminDaoImpl();
	BorrowerDao borrDao=new BorrowerDaoImpl();
	String returnJsp=null;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session=req.getSession();
		int id=Integer.parseInt(req.getParameter("username"));
		String password=req.getParameter("password");
		int loginType=Integer.parseInt(req.getParameter("status"));	//用户类型
		
		//查询图书类型
		BookTypeDao typeDao=new BookTypeDaoImpl();
		IdentityDao idDao=new IdentityDaoImpl();
		List<BookType> typeList=typeDao.findAllType();
		List<Identity> idList=idDao.findAllIdentity();
		System.out.println(typeList.get(0).getName());
		System.out.println(idList.get(0).getName());
		session.setAttribute("typeList", typeList);
		session.setAttribute("idList", idList);
		
		
		if(loginType==1) {
			Admin admin=adminDao.findAdmin(id, password);	//管理员
			if(admin!=null) {
				session.setAttribute("UserType", "A");
				session.setAttribute("id", admin.getId());
				session.setAttribute("User", admin);
				returnJsp= "admin.jsp";
			}else {
				req.setAttribute("str","用户名或密码错误!");
				returnJsp= "login.jsp";
			}
		}else{
			Borrower borrower=borrDao.findBorrower(id+"", password, loginType);
			if(borrower!=null) {
				session.setAttribute("UserType", "B");
				session.setAttribute("id", borrower.getBorrowerId());
				session.setAttribute("User", borrower);
				req.setAttribute("IdentityId",borrower.getIdentityId());
				session.setAttribute("IdentityId", borrower.getIdentityId());
				System.out.println(borrower.getPhone());
				System.out.println(borrower.getIdentityId());
				returnJsp= "ApersonalInfo.jsp";
			}else {
				req.setAttribute("str","用户名或密码错误!");
				returnJsp= "login.jsp";
			}
		}
		
		return returnJsp;
	}

}

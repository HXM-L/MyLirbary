package action;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import dao.AdminDao;
import dao.BorrowerDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BorrowerDaoImpl;
import framework.Action;

public class UpdateInfoAction implements Action {	//修改信息

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) { // 更新用户信息
		AdminDao adminDao = new AdminDaoImpl();
		BorrowerDao bDao=new BorrowerDaoImpl();
		String URL=null;
		if (req.getSession().getAttribute("UserType").equals("A")) { // 更新管理员信息
			Admin admin = (Admin) req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(req.getSession().getAttribute("UserType"));
			// 把修改的值传回页面,session中存有admin对象的值
			try {
				admin.setName(new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			admin.setPhone(req.getParameter("phone"));
			if (adminDao.updateAdminInfo(admin)) {
				req.setAttribute("updateFlag", "更新成功");
				System.out.println(req.getAttribute("updateFlag"));
			} else {
				req.setAttribute("updateFlag", "更新失败");
			}
			URL="updateAdminInfo.jsp";
		} else {	//更新普通用户信息
			System.out.println(req.getSession().getAttribute("UserType"));
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
			System.out.println(borrower.getBorrowerId());
			System.out.println(borrower.getName());
				borrower.setName(req.getParameter("username"));
				borrower.setRemarks(req.getParameter("remarks"));
			borrower.setPhone(req.getParameter("phone"));
//			borrower.setIdentityId(Integer.parseInt(req.getParameter("type")));
//			borrower.setStatus(req.getParameter("status"));
//			float money=Float.parseFloat(req.getParameter("money"));
//			borrower.setMoney(money);
			if (bDao.updateBorrower(borrower)) {
				req.setAttribute("updateFlag", "更新成功");
				System.out.println(req.getAttribute("updateFlag"));
			} else {
				req.setAttribute("updateFlag", "更新失败");
			}
			URL="AUpdatepersonalInfo.jsp";
		}

		return URL;
	}

}

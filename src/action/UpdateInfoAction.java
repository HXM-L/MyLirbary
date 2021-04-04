package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import framework.Action;

public class UpdateInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) { // 更新用户信息
		AdminDao adminDao = new AdminDaoImpl();
		String newPwd = null;
		try {
			newPwd = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (req.getSession().getAttribute("UserType").equals("A")) { // 更新管理员信息
			Admin admin = (Admin) req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(newPwd);
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

		} else {	//更新普通用户信息
			Borrower borrower = (Borrower) req.getSession().getAttribute(("User"));
		}

		return "updateAdminInfo.jsp";
	}

}

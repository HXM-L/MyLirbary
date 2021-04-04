package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import framework.Action;

public class UpdateInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	//更新用户信息
		String newPwd = req.getParameter("npwd");
		if(req.getSession().getAttribute("UserType").equals("A")) {	//更新管理员信息
			Admin admin=(Admin)req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(newPwd);
			System.out.println(req.getSession().getAttribute("UserType"));
			//把修改的值传回页面,session中存有admin对象的值
			admin.setName("张三");
			admin.setPhone("123456789");
			req.setAttribute("updateFlag", "更新成功");
		}else {
			Borrower borrower=(Borrower) req.getSession().getAttribute(("User"));
		}
		
		return "updateAdminInfo.jsp";
	}

}

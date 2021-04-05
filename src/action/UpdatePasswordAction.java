package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import dao.BorrowerDao;
import dao.impl.BorrowerDaoImpl;
import framework.Action;

public class UpdatePasswordAction implements Action {

	BorrowerDao bdao = new BorrowerDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String newPwd = req.getParameter("npwd");
		String URL=null;
		if(req.getSession().getAttribute("UserType").equals("A")) {
			Admin admin=(Admin)req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(newPwd);
			System.out.println(req.getSession().getAttribute("UserType"));
			if(bdao.updateBorrower(admin.getId()+"", admin.getName(),newPwd)) {
				req.setAttribute("updateFlag", "�޸�����ɹ�");
				URL="login.jsp";
			}else {
				req.setAttribute("updateFlag", "�޸�����ʧ��");
				URL="updatePwd.jsp";
			}
		}else {
			Borrower borrower=(Borrower) req.getSession().getAttribute(("User"));
			bdao.updateBorrower(borrower.getBorrowerId(), borrower.getName(),newPwd);
		}
		
		return URL;
	}

}

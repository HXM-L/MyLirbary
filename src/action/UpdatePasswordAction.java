package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import dao.AdminDao;
import dao.BorrowerDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BorrowerDaoImpl;
import framework.Action;

public class UpdatePasswordAction implements Action {	//�޸�����

	BorrowerDao bdao = new BorrowerDaoImpl();
	AdminDao aDao=new AdminDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String newPwd = req.getParameter("npwd");
		String URL=null;
		if(req.getSession().getAttribute("UserType").equals("A")) {	//�޸Ĺ���Ա����
			Admin admin=(Admin)req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(newPwd);
			System.out.println(req.getSession().getAttribute("UserType"));
			if(aDao.updateAdminPwd(admin.getId()+"", admin.getName(),newPwd)) {
				req.setAttribute("error", "�޸�����ɹ�,�����µ�¼.");
				URL="login.jsp";
			}else {
				req.setAttribute("error", "�޸�����ʧ��!");
				URL="updatePwd.jsp";
			}
		}else {
			Borrower borrower=(Borrower) req.getSession().getAttribute(("User"));
			if(bdao.updateBorrower(borrower.getBorrowerId()+"", borrower.getName(),newPwd)) {
				req.setAttribute("error", "�޸�����ɹ�,�����µ�¼.");
				URL="login.jsp";
			}else {
				req.setAttribute("error", "�޸�����ʧ��!");
				URL="AupdatePwd.jsp";
			}
		}
		
		return URL;
	}

}

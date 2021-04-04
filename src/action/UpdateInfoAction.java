package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import framework.Action;

public class UpdateInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {	//�����û���Ϣ
		String newPwd = req.getParameter("npwd");
		if(req.getSession().getAttribute("UserType").equals("A")) {	//���¹���Ա��Ϣ
			Admin admin=(Admin)req.getSession().getAttribute(("User"));
			System.out.println(admin.getId());
			System.out.println(admin.getName());
			System.out.println(newPwd);
			System.out.println(req.getSession().getAttribute("UserType"));
			//���޸ĵ�ֵ����ҳ��,session�д���admin�����ֵ
			admin.setName("����");
			admin.setPhone("123456789");
			req.setAttribute("updateFlag", "���³ɹ�");
		}else {
			Borrower borrower=(Borrower) req.getSession().getAttribute(("User"));
		}
		
		return "updateAdminInfo.jsp";
	}

}

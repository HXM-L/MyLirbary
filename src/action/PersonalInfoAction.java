package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Borrower;
import dao.BorrowerDao;
import dao.impl.BorrowerDaoImpl;
import framework.Action;

public class PersonalInfoAction implements Action {	//�޸���Ϣ

	BorrowerDao bdao = new BorrowerDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String bid = req.getParameter("bid");
		Borrower b = bdao.findBorrowerByBorrowerId(bid);
		if(name==null) {
			name=b.getName();
		}
		if(phone==null) {
			phone=b.getPhone();
		}
		if(password==null) {
			req.setAttribute("str", "���벻��Ϊ�գ�");
			password=b.getPassword();
		}
		boolean isFlag = bdao.updateBorrower(bid, name,password,phone);
		req.setAttribute("isFlag", isFlag);
		return "";
	}

}

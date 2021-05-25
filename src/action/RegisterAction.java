package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Borrower;
import dao.AdminDao;
import dao.BorrowerDao;
import dao.impl.AdminDaoImpl;
import dao.impl.BorrowerDaoImpl;
import framework.Action;

public class RegisterAction implements Action { // 修改密码

	BorrowerDao bdao = new BorrowerDaoImpl();
	AdminDao aDao = new AdminDaoImpl();

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String realyName = null;
		String remarks=null;
		String URL = null;
			realyName = req.getParameter("realyName");
			remarks = req.getParameter("remarks");
		BorrowerDao bDao=new BorrowerDaoImpl();
		List<Borrower> bList=bDao.findAllBorrower();
		int length=bList.size();
		System.out.println(bList.get(length-1).getBorrowerId());
		String borrowerId=Integer.parseInt(bList.get(length-1).getBorrowerId())+1+"";
		String password=req.getParameter("pwd");
		String phone=req.getParameter("phone");
		int identityId=Integer.parseInt(req.getParameter("identityId"));
		int num=0;
		if(identityId==2) {
			num=15;
		}else if(identityId==3) {
			num=30;
		}else if(identityId==4) {
			num=20;
		}
		String status="正常";
		Borrower borrower=new Borrower();
		borrower.setBorrowerId(borrowerId);
		borrower.setName(realyName);
		borrower.setPassword(password);
		borrower.setRemarks(remarks);
		borrower.setPhone(phone);
		borrower.setNum(num);
		borrower.setStatus(status);
		borrower.setIdentityId(identityId);
		System.out.println(borrowerId);
		if(bDao.addBorrower(borrower)) {
			req.setAttribute("error", "用户注册成功!您好的账号是:"+borrowerId);
			req.setAttribute("borrowerId", borrowerId);
			URL = "login.jsp";
		}else {
			req.setAttribute("error", "用户注册失败!");
			URL = "register.jsp";
		}
		return URL;
	}

}

package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reserve;
import dao.ReserveDao;
import dao.impl.ReserveDaoImpl;
import framework.Action;

public class OrderhistoryAction implements Action {
	//用户查找预定图书记录

	ReserveDao rdao = new ReserveDaoImpl();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String borrowerId = req.getParameter("bid");
		List<Reserve> lr = null;
		lr = rdao.findReserveByBorrowerId(borrowerId);
		if(lr.size()>0) {
			req.setAttribute("lr", lr);
			return "";
		}else {
			req.setAttribute("str", "您没有预约图书！");
			return "";
		}
	}

}

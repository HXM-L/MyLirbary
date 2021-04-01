package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Borrower;
import dao.BorrowerDao;
import dbc.BaseDao;

public class BorrowerDaoImpl extends BaseDao implements BorrowerDao {

	@Override
	public Borrower findBorrower(String borrowerId, String password, int type) {
		return (Borrower) this.query("select * from borrower where borrowerId=" + borrowerId + "and password="
				+ password + "and identityId=" + type, new ArrayList<Object>(), Borrower.class).get(0);
	}

	@Override
	public boolean updateBorrower(String borrowerId,String name,String password,String phone) {
		boolean isFlag = false;
		String sql = "update borrower set name =?,password=?,phone=? where borrowerId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(name);
		lp.add(password);
		lp.add(phone);
		lp.add(borrowerId);
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}

	@Override
	public boolean delBorrower(String borrowerId) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "delete from borrower where borrowerId =?";
		lp.add(borrowerId);
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}

	@Override
	public Borrower findBorrowerByBorrowerId(String bid) {
		Borrower b = null;
		List<Borrower> lb = new ArrayList<Borrower>();
		List<Object> lp = new ArrayList<Object>();
		String sql ="select * from borrower where borrowerId = ?";
		lp.add(bid);
		lb = this.query(sql, lp, Borrower.class);
		if(lb.size()>0) {
			b=lb.get(0);
		}
		return b;
	}

	@Override
	public boolean updateBorrower(String borrowerId, String name, String password) {
		boolean isFlag = false;
		String sql = "update borrower set name =?,password=? where borrowerId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(name);
		lp.add(password);
		lp.add(borrowerId);
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}


}

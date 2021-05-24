package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Borrower;
import dao.BorrowerDao;
import dbc.BaseDao;

public class BorrowerDaoImpl extends BaseDao implements BorrowerDao {

	@Override
	public Borrower findBorrower(String borrowerId, String password, int type) {
		String sql="select * from borrower where borrowerId=" + borrowerId + "and password="+ password + "and identityId=" + type;
		if(this.query(sql, new ArrayList<Object>(), Borrower.class).size()==0) {
			//这个地方只能用size来判断，如果判断是否为null的话会报错的，因为list集合本身是不会为null
			return null;
		}
		return (Borrower) this.query(sql, new ArrayList<Object>(), Borrower.class).get(0);
	}

	@Override
	public boolean updateBorrower(Borrower borrower) {
		boolean isFlag = false;
		String sql = "update borrower set name =?,remarks=?,phone=? where borrowerId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(borrower.getName());
		lp.add(borrower.getRemarks());
		lp.add(borrower.getPhone());
		lp.add(borrower.getBorrowerId());
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

	@Override
	public List<Borrower> findAllBorrower() {
		return this.query("select * from borrower", new ArrayList<Object>(), Borrower.class);
	}

	@Override
	public boolean addBorrower(Borrower borrower) {
		List<Object> lp = new ArrayList<Object>();
		String sql="insert into borrower values(?,?,?,?,?,?,?,?,?)";
		lp.add(borrower.getBorrowerId());
		lp.add(borrower.getName());
		lp.add(borrower.getPassword());
		lp.add(borrower.getRemarks());
		lp.add(borrower.getPhone());
		lp.add(borrower.getMoney());
		lp.add(borrower.getNum());
		lp.add(borrower.getStatus());
		lp.add(borrower.getIdentityId());
		return this.upadte(sql, lp);
	}


}

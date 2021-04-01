package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Reserve;
import dao.ReserveDao;
import dbc.BaseDao;

public class ReserveDaoImpl extends BaseDao implements ReserveDao {

	@Override
	public boolean doReserve(Reserve r) {
		boolean isFlag = false;
		List<Object> lp =new ArrayList<Object>();
		String sql ="insert into reserve values(?,?,?,?,?)";
		lp.add(r.getBookid());
		lp.add(r.getborowerId());
		lp.add(r.getReserveTime());
		lp.add(r.getFetchTime());
		lp.add(r.getStatus());
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}

	@Override
	public List<Reserve> findReserveByBorrowerId(String borrowerId) {
		List<Reserve> lr = null;
		List<Object> lp = new ArrayList<Object>();
		String sql ="select * from reserve where borowerId =?";
		lp.add(borrowerId);
		lr=this.query(sql, lp, Reserve.class);
		return lr;
	}

}

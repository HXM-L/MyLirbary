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
		String sql ="insert into reserve values(?,?,?,?,?,?)";
		lp.add(r.getselfId());
		lp.add(r.getBorowerId());
		lp.add(r.getReserveTime());
		lp.add(r.getFetchTime());
		lp.add(r.getStatus());
		lp.add(r.getBookName());
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

	@Override
	public List<Reserve> findReseRecord() {
		return this.query("select * from reserve", new ArrayList<Object>(), Reserve.class);
	}

	@Override
	public Reserve findReserveById(int reserveid) {
		return (Reserve) this.query("select * from reserve where reserveid = "+reserveid, new ArrayList<Object>(), Reserve.class).get(0);
	}

	@Override
	public boolean deleteReserveRecord(int reserveid) {
		String sql = "delete from reserve where reserveid = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(reserveid);
		return this.upadte(sql, lp);
	}

	@Override
	public boolean updateReserveById(Reserve reserve) {
		String sql = "update reserve set bookid = ?,borowerId = ?,reserveTime = ?,fetchTime = ?,status = ?,bookName = ? where reserveid = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(reserve.getselfId());
		lp.add(reserve.getBorowerId());
		lp.add(reserve.getReserveTime());
		lp.add(reserve.getFetchTime());
		lp.add(reserve.getStatus());
		lp.add(reserve.getBookName());
		lp.add(reserve.getReserveid());
		return this.upadte(sql, lp);
	}

}

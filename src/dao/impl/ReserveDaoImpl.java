package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Reserve;
import dao.ReserveDao;
import dbc.BaseDao;

public class ReserveDaoImpl extends BaseDao implements ReserveDao {

	@Override
	public boolean doReserve(Reserve r) {	//添加一条预定 
		boolean isFlag = false;
		List<Object> lp =new ArrayList<Object>();
		String sql ="insert into reserve(selfId,bookName,borowerId,reserveTime) values(?,?,?,?)";
		lp.add(r.getselfId());
		lp.add(r.getBookName());
		lp.add(r.getBorowerId());
		lp.add(r.getReserveTime());
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
		String sql = "update reserve set selfId = ?,borowerId = ?,reserveTime = ?,fetchTime = ?,status = ?,bookName = ? where reserveid = ?";
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

	@Override
	public List<Reserve> findReseRecord(String userID) {
		return this.query("select * from reserve where borowerId="+userID, new ArrayList<Object>(), Reserve.class);
	}

}

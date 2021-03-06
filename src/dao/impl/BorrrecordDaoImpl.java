package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bean.Borrrecord;
import bean.Reserve;
import dao.BorrrecordDao;
import dbc.BaseDao;

public class BorrrecordDaoImpl extends BaseDao implements BorrrecordDao {

	@Override
	public Borrrecord findRecordByBorrowerId(String borrRecordId) {
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where borrRecordId = ?";
		lp.add(borrRecordId);
		Borrrecord record=(Borrrecord) this.query(sql, lp, Borrrecord.class).get(0);
		return record;
	}

	@Override
	public List<Borrrecord> findOvertimeByBorrowerId(String borrowerId) {
		List<Borrrecord> lb = null;
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where borrowerId=? and overTime = 1";
		lp.add(borrowerId);
		lb = this.query(sql, lp, Borrrecord.class);
		return lb;
	}

	@Override
	public boolean doBorrrecord(List<Reserve> lr) {
		boolean isFlag = false;
		for(Reserve r:lr) {
			if(r.getStatus().equals("是")) {
				List<Object> lp = new ArrayList<Object>();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
				Date now = new Date();
				String borrrecordid = df.format(now);//借阅id
				int aginBorr = 0;//默认不续借
				int overTime = 0;//默认不超期
				int returnFlag = 0;//默认未归还
				String borrTime = r.getFetchTime();
				Date rTime = null;
				try {
					rTime = stepMonth(ft.parse(borrTime), 3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String returnTime = ft.format(rTime);//默认还书三个月
				String sql = "insert into borrrecord values(?,?,?,?,?,?,?,?)";
				lp.add(borrrecordid);
				lp.add(r.getBorowerId());
				lp.add(returnFlag);
				lp.add(r.getselfId());
				lp.add(borrTime);
				lp.add(returnTime);
				lp.add(aginBorr);
				lp.add(overTime);
				isFlag = this.upadte(sql, lp);
			}
		}
		return isFlag;
	}

	@Override
	public boolean updateBorrrecordByBorrowerId(String bid,String bookid,String returnTime) {
		boolean isFlag = false;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date rTime = null;
		try {
			rTime = stepMonth(ft.parse(returnTime), 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newTime = ft.format(rTime);
		List<Object> lp = new ArrayList<Object>();
		String sql = "update borrrecord set returnTime = ? where borrowerId = ?";
		lp.add(newTime);
		lp.add(bid);
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}
	
	public static Date stepMonth(Date s,int m) {
		 Calendar c = Calendar.getInstance();
		 c.setTime(s);
		 c.add(Calendar.MONTH, m);
		 return c.getTime();
	}

	@Override
	public boolean updateOverTimeByBorrowerId(String bid,String bookid) {
		boolean isFlag = false;
		List<Object> lp = new ArrayList<Object>();
		String sql = "update borrrecord set overTime = ? where borrowerId = ? and bookid =?";
		lp.add(1);
		lp.add(bid);
		lp.add(bookid);
		isFlag = this.upadte(sql, lp);
		return isFlag;
	}

	@Override
	public Borrrecord findBorrrecord(String bid, String bookid) {
		Borrrecord b=null;
		List<Borrrecord> lb = null;
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where borrowerId=? and bookid = ?";
		lp.add(bid);
		lp.add(bookid);
		lb = this.query(sql, lp, Borrrecord.class);
		if(lb.size()>0) {
			b=lb.get(0);
		}
		return b;
	}

	@Override
	public List<Borrrecord> findNowRecordByBorrowerId(String borrowerId) {
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where borrowerId = ? and returnFlag = '否'";
		lp.add(borrowerId);
		return this.query(sql, lp, Borrrecord.class);
	}

	@Override
	public List<Borrrecord> findRecordByBorrower(String borrowerId) {
		String sql = "select * from borrrecord where returnFlag ='否' and overTime='是'  and borrowerId="+borrowerId;
		return this.query(sql, new ArrayList<Object>(), Borrrecord.class);
	}

	@Override
	public boolean updateRecordByRID(Borrrecord brecord) {
		List<Object> lp = new ArrayList<Object>();
		String sql = "update borrrecord set borrowerId = ?,returnFlag=?,bookid=?,borrTime=?,returnTime=?,aginBorr=?,overTime=?,bookName=? where borrRecordId = ?";
		lp.add(brecord.getBorrowerId());
		lp.add(brecord.getReturnFlag());
		lp.add(brecord.getBookid());
		lp.add(brecord.getBorrTime());
		lp.add(brecord.getReturnTime());
		lp.add(brecord.getAginBorr());
		lp.add(brecord.getOverTime());
		lp.add(brecord.getBookName());
		lp.add(brecord.getBorrRecordId());
		return this.upadte(sql, lp);
	}

	@Override
	public boolean deleteRecord(String recordID) {
		List<Object> lp = new ArrayList<Object>();
		String sql = "delete from borrrecord where borrRecordId = ?";
		lp.add(recordID);
		return this.upadte(sql, lp);
	}

	@Override
	public List<Borrrecord> findBorrowIng() {
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where returnFlag='否'";
		return this.query(sql, lp, Borrrecord.class);
	}

	@Override
	public List<Borrrecord> findUrge() {
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from borrrecord where returnFlag='否' and overTime='是'";
		return this.query(sql, lp, Borrrecord.class);
	}

	@Override
	public List<Borrrecord> findAllRecords() {
		String sql = "select * from borrrecord";
		return this.query(sql, new ArrayList<Object>(), Borrrecord.class);
	}

	@Override
	public List<Borrrecord> findAllRecords(String borrowerId) {
		String sql = "select * from borrrecord where borrowerId="+borrowerId;
		return this.query(sql, new ArrayList<Object>(), Borrrecord.class);
	}
}

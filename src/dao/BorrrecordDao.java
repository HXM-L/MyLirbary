package dao;

import java.util.List;

import bean.Borrrecord;
import bean.Reserve;

public interface BorrrecordDao {

	public Borrrecord findRecordByBorrowerId(String borrowerId);// 查询指定记录id的借阅历史

	public List<Borrrecord> findRecordByBorrower();// 查询所有借阅历史

	public List<Borrrecord> findNowRecordByBorrowerId(String borrowerId);// 查询的指定读者当前的借阅

	public List<Borrrecord> findOvertimeByBorrowerId(String borrowerId);// 浏览超期图书

	public boolean doBorrrecord(List<Reserve> lr);// 取完书自动添加借阅记录

	public boolean updateBorrrecordByBorrowerId(String bid, String bookid, String returnTime);// 续借更新还书日期

	public boolean updateOverTimeByBorrowerId(String bid, String bookid);// 更新超期

	public Borrrecord findBorrrecord(String bid, String bookid);// 定位一本书

	public boolean updateRecordByRID(Borrrecord brecord); // 更新指定borrowerId的借阅记录
	
	public boolean deleteRecord(String recordID);	//删除一条记录
	
	public List<Borrrecord> findBorrowIng();	//查询没有归还图书的借阅记录
	
	public List<Borrrecord> findUrge();	//查询需要催还图书的记录
}

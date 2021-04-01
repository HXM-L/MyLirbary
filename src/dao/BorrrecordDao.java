package dao;

import java.util.List;

import bean.Borrrecord;
import bean.Reserve;

public interface BorrrecordDao {

	public List<Borrrecord> findRecordByBorrowerId(String borrowerId);// 查询借阅历史
	
	public List<Borrrecord> findRecordByBorrower();// 查询所有借阅历史

	public List<Borrrecord> findNowRecordByBorrowerId(String borrowerId);// 查询的当前的借阅

	public List<Borrrecord> findOvertimeByBorrowerId(String borrowerId);// 浏览超期图书

	public boolean doBorrrecord(List<Reserve> lr);// 取完书自动添加借阅记录

	public boolean updateBorrrecordByBorrowerId(String bid, String bookid, String returnTime);// 续借更新还书日期

	public boolean updateOverTimeByBorrowerId(String bid, String bookid);// 更新超期

	public Borrrecord findBorrrecord(String bid, String bookid);// 定位一本书
}

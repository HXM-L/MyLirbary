package dao;

import java.util.List;

import bean.Reserve;

public interface ReserveDao { // 预定记录表的操作

	public boolean doReserve(Reserve r);// 添加网上预订图书

	public List<Reserve> findReserveByBorrowerId(String borrowerId);// 浏览个人预订图书

	public List<Reserve> findReseRecord(); // 所有预定记录
	
	public List<Reserve> findReseRecord(String userID); // 指定读者ID所有预定记录
	
	public Reserve findReserveById(int reserveid);	//根据记录id查询记录
	
	public boolean deleteReserveRecord(int reserveid);	//删除一条预定记录
	
	public boolean updateReserveById(Reserve reserve);	//根据记录id更新一条数据
}

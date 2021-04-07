package dao;

import java.util.List;

import bean.Reserve;

public interface ReserveDao {

	public boolean doReserve(Reserve r);//添加网上预订图书
	
	public List<Reserve> findReserveByBorrowerId(String borrowerId);//浏览个人预订图书
}

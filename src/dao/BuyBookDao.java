package dao;

import java.util.List;

import bean.BuyBook;

public interface BuyBookDao {
	public boolean doBuyBook(BuyBook buyBook); // 添加购书清单

	public boolean modifyBuyBook(BuyBook buyBook); // 修改购书清单

	public boolean deleteBuyBook(String buyBookId); // 删除一条购书记录

	public List<BuyBook> findAllBuyBook(); // 查询所有购书记录

	public BuyBook findRecordByID(String buyBookId); // 查询所有购书记录
}

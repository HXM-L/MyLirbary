package dao;

import java.util.List;

import bean.Borrower;

public interface BorrowerDao {
	public Borrower findBorrower(String borrowerId, String password, int type); // 查询借阅人信息

	public boolean updateBorrower(Borrower borrower);// 修改个人信息

	public boolean updateBorrower(String borrowerId, String name, String password);// 修改个人密码

	public boolean delBorrower(String borrowerId);// 注销账户

	public Borrower findBorrowerByBorrowerId(String bid);// 根据id返回用户
	
	public List<Borrower> findAllBorrower();	//查找所有用户
	
	public boolean addBorrower(Borrower borrower);	//注册新用户
}

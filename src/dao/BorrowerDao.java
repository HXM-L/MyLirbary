package dao;

import bean.Borrower;

public interface BorrowerDao {
	public Borrower findBorrower(String borrowerId, String password, int type); // t查询借阅人信息

	public boolean updateBorrower(Borrower borrower);// 修改个人信息

	public boolean updateBorrower(String borrowerId, String name, String password);// 修改个人密码

	public boolean delBorrower(String borrowerId);// 注销账户

	public Borrower findBorrowerByBorrowerId(String bid);// 根据id返回用户
}

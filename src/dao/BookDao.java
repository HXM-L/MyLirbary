package dao;

import bean.Book;

public interface BookDao {
	public boolean doBook(Book book);	//添加图书信息
	public boolean deleteBook(String selfid);	//删除图书信息
	public boolean setBookStatus(String state,String selfid);	//设置图书可借阅状态
	public String findSelfId(String bookid);	//查找selfid
}

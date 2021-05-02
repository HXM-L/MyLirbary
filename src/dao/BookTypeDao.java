package dao;

import java.util.List;

import bean.BookType;

public interface BookTypeDao {

	public BookType findBookTypeByTyprid(String name);	//根据类型名称查找类型值
	public List<BookType> findAllType();	//查找所有图书类型
	public boolean doBookType(BookType bookType);	//添加图书类型
	public BookType findTypeById(int typeid);	//根据图书类型值查找图书类型名称
}

package dao;

import java.util.List;

import bean.Self;

public interface SelfDao { // 书架表
	public boolean doSelf(Self self); // 图书上架

	public Self findBookBySelfId(String selfId); // 查找所在书架的位置的图书信息

	public boolean deleteSelf(String selfId); // 图书下架

	public List<Self> findBookBybookTypeId(int typeid, String bookname, String publisher, String author);// 根据图书属性查询

	public List<Self> findAllBook();// 查询所有图书
}

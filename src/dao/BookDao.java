package dao;

import bean.Book;

public interface BookDao {
	public boolean doBook(Book book);	//���ͼ����Ϣ
	public boolean deleteBook(String selfid);	//ɾ��ͼ����Ϣ
	public boolean setBookStatus(String state,String selfid);	//����ͼ��ɽ���״̬
	public String findSelfId(String bookid);	//����selfid
}

package dao;

import java.util.List;

import bean.BookType;

public interface BookTypeDao {

	public BookType findBookTypeByTyprid(String name);	//�����������Ʋ�������ֵ
	public List<BookType> findAllType();	//��������ͼ������
}

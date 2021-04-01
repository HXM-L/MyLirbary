package dao;

import java.util.List;

import bean.Self;

public interface SelfDao { // ��ܱ�
	public boolean doSelf(Self self); // ͼ���ϼ�

	public Self findBookBySelfId(String selfId); // ����������ܵ�λ�õ�ͼ����Ϣ

	public boolean deleteSelf(String selfId); // ͼ���¼�

	public List<Self> findBookBybookTypeId(int typeid, String bookname, String publisher, String author);// ����ͼ�����Բ�ѯ

	public List<Self> findAllBook();// ��ѯ����ͼ��
}

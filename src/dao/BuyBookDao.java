package dao;

import java.util.List;

import bean.BuyBook;

public interface BuyBookDao {
	public boolean doBuyBook(BuyBook buyBook);	//��ӹ����嵥
	public boolean modifyBuyBook(List<Object> list,String buyBookId);	//�޸Ĺ����嵥
	public boolean deleteBuyBook(String buyBookId);	//ɾ��һ�������¼
	public List<BuyBook> findAllBuyBook();	//��ѯ���й����¼
}

package dao;

import java.util.List;

import bean.BuyBook;

public interface BuyBookDao {
	public boolean doBuyBook(BuyBook buyBook); // ��ӹ����嵥

	public boolean modifyBuyBook(BuyBook buyBook); // �޸Ĺ����嵥

	public boolean deleteBuyBook(String buyBookId); // ɾ��һ�������¼

	public List<BuyBook> findAllBuyBook(); // ��ѯ���й����¼

	public BuyBook findRecordByID(String buyBookId); // ��ѯ���й����¼
}

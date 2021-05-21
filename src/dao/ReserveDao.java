package dao;

import java.util.List;

import bean.Reserve;

public interface ReserveDao { // Ԥ����¼��Ĳ���

	public boolean doReserve(Reserve r);// �������Ԥ��ͼ��

	public List<Reserve> findReserveByBorrowerId(String borrowerId);// �������Ԥ��ͼ��

	public List<Reserve> findReseRecord(); // ����Ԥ����¼
	
	public List<Reserve> findReseRecord(String userID); // ָ������ID����Ԥ����¼
	
	public Reserve findReserveById(int reserveid);	//���ݼ�¼id��ѯ��¼
	
	public boolean deleteReserveRecord(int reserveid);	//ɾ��һ��Ԥ����¼
	
	public boolean updateReserveById(Reserve reserve);	//���ݼ�¼id����һ������
}

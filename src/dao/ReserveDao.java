package dao;

import java.util.List;

import bean.Reserve;

public interface ReserveDao {

	public boolean doReserve(Reserve r);//����Ԥ��ͼ��
	
	public List<Reserve> findReserveByBorrowerId(String borrowerId);//�������Ԥ��ͼ��
}

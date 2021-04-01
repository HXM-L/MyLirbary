package dao;

import java.util.List;

import bean.Borrrecord;
import bean.Reserve;

public interface BorrrecordDao {

	public List<Borrrecord> findRecordByBorrowerId(String borrowerId);// ��ѯ������ʷ
	
	public List<Borrrecord> findRecordByBorrower();// ��ѯ���н�����ʷ

	public List<Borrrecord> findNowRecordByBorrowerId(String borrowerId);// ��ѯ�ĵ�ǰ�Ľ���

	public List<Borrrecord> findOvertimeByBorrowerId(String borrowerId);// �������ͼ��

	public boolean doBorrrecord(List<Reserve> lr);// ȡ�����Զ����ӽ��ļ�¼

	public boolean updateBorrrecordByBorrowerId(String bid, String bookid, String returnTime);// ������»�������

	public boolean updateOverTimeByBorrowerId(String bid, String bookid);// ���³���

	public Borrrecord findBorrrecord(String bid, String bookid);// ��λһ����
}
package dao;

import java.util.List;

import bean.Borrrecord;
import bean.Reserve;

public interface BorrrecordDao {

	public Borrrecord findRecordByBorrowerId(String borrowerId);// ��ѯָ����¼id�Ľ�����ʷ

	public List<Borrrecord> findRecordByBorrower();// ��ѯ���н�����ʷ

	public List<Borrrecord> findNowRecordByBorrowerId(String borrowerId);// ��ѯ��ָ�����ߵ�ǰ�Ľ���

	public List<Borrrecord> findOvertimeByBorrowerId(String borrowerId);// �������ͼ��

	public boolean doBorrrecord(List<Reserve> lr);// ȡ�����Զ���ӽ��ļ�¼

	public boolean updateBorrrecordByBorrowerId(String bid, String bookid, String returnTime);// ������»�������

	public boolean updateOverTimeByBorrowerId(String bid, String bookid);// ���³���

	public Borrrecord findBorrrecord(String bid, String bookid);// ��λһ����

	public boolean updateRecordByRID(Borrrecord brecord); // ����ָ��borrowerId�Ľ��ļ�¼
	
	public boolean deleteRecord(String recordID);	//ɾ��һ����¼
	
	public List<Borrrecord> findBorrowIng();	//��ѯû�й黹ͼ��Ľ��ļ�¼
	
	public List<Borrrecord> findUrge();	//��ѯ��Ҫ�߻�ͼ��ļ�¼
}

package dao;

import java.util.List;

import bean.Borrower;

public interface BorrowerDao {
	public Borrower findBorrower(String borrowerId, String password, int type); // ��ѯ��������Ϣ

	public boolean updateBorrower(Borrower borrower);// �޸ĸ�����Ϣ

	public boolean updateBorrower(String borrowerId, String name, String password);// �޸ĸ�������

	public boolean delBorrower(String borrowerId);// ע���˻�

	public Borrower findBorrowerByBorrowerId(String bid);// ����id�����û�
	
	public List<Borrower> findAllBorrower();	//���������û�
	
	public boolean addBorrower(Borrower borrower);	//ע�����û�
}

package dao;

import bean.Admin;

public interface AdminDao {
	public Admin findAdmin(int id,String password);	//��ѯ����Ա��Ϣ
	public boolean updateAdminInfo(Admin user);	//�޸Ĺ���Ա��Ϣ
}

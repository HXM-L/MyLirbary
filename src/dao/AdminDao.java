package dao;

import bean.Admin;

public interface AdminDao {
	public Admin findAdmin(int id,String password);	//查询管理员信息
	public boolean updateAdminInfo(Admin user);	//修改管理员信息
	public boolean updateAdminPwd(String id,String name,String password); 	//更新密码
}

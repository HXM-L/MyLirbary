package dao;

import bean.Admin;

public interface AdminDao {
	public Admin findAdmin(int id,String password);	//查询管理员信息
}

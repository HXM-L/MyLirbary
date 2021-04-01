package dao.impl;

import java.util.ArrayList;

import bean.Admin;
import dao.AdminDao;
import dbc.BaseDao;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin findAdmin(int id, String password) {	//查询管理员信息
		return (Admin) this.query("select * from admin where id="+id+"and password="+password, new ArrayList<Object>(), Admin.class).get(0);
	}

}

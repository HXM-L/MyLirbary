package dao.impl;

import java.util.ArrayList;

import bean.Admin;
import dao.AdminDao;
import dbc.BaseDao;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin findAdmin(int id, String password) {	//��ѯ����Ա��Ϣ
		return (Admin) this.query("select * from admin where id="+id+"and password="+password, new ArrayList<Object>(), Admin.class).get(0);
	}

}

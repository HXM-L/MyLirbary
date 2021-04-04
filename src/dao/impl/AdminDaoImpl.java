package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import dao.AdminDao;
import dbc.BaseDao;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin findAdmin(int id, String password) {	//查询管理员信息
		return (Admin) this.query("select * from admin where id="+id+"and password="+password, new ArrayList<Object>(), Admin.class).get(0);
	}

	@Override
	public boolean updateAdminInfo(Admin user) {
		String sql="update admin set name=?,phone=? where id=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(user.getName());
		lp.add(user.getPhone());
		lp.add(user.getId());
		return this.upadte(sql, lp);
	}

}

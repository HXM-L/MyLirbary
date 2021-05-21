package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BookType;
import bean.Identity;
import dao.IdentityDao;
import dbc.BaseDao;

public class IdentityDaoImpl extends BaseDao implements IdentityDao {

	@Override
	public List<Identity> findAllIdentity() {
		//https://blog.csdn.net/weixin_30498921/article/details/96401511
		//���õ����ݿ�ı���identity��sql���ǹؼ���,Ҫ��[ ] 
		return this.query("select * from [identity]",new ArrayList<Object>(),Identity.class);
	}

}

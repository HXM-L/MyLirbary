package dao;

import java.util.List;

import bean.Identity;

public interface IdentityDao {
	public List<Identity> findAllIdentity();	//查找所有身份类型

}

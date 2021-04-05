package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BookType;
import dao.BookTypeDao;
import dbc.BaseDao;

public class BookTypeDaoImpl extends BaseDao implements BookTypeDao {

	@Override
	public BookType findBookTypeByTyprid(String name) {
		List<Object> lp = new ArrayList<Object>();
		List<BookType> lb =null;
		BookType bt = null;
		String sql = "select * from booktype where name = ?";
		lp.add(name);
		lb = this.query(sql, lp, BookType.class);
		if(lb.size()>0) {
			bt = lb.get(0);
		}
		return bt;
	}

	@Override
	public List<BookType> findAllType() {
		return this.query("select * from booktype",new ArrayList<Object>(),BookType.class);
	}

}

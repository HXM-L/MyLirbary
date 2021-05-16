package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Self;
import dao.BookTypeDao;
import dao.SelfDao;
import dbc.BaseDao;

public class SelfDaoImpl extends BaseDao implements SelfDao {

	@Override
	public boolean doSelf(Self self) { // 图书上架
		String sql = "insert into self values(?,?,?,?,?,?,?,?,?)";
		List<Object> lp = new ArrayList<Object>();
		lp.add(self.getSelfId());
		lp.add(self.getBookname());
		lp.add(self.getAuthor());
		lp.add(self.getPublisherDate());
		lp.add(self.getBookNum());
		lp.add(self.getTypeId());
		lp.add(self.getPicture());
		lp.add(self.getIntroduction());
		lp.add(self.getPublisher());
		return this.upadte(sql, lp);
	}

	@Override
	public Self findBookBySelfId(String selfId) { // 查找图书
		return (Self) this
				.query("select * from self where selfId='" + selfId + "'", new ArrayList<Object>(), Self.class).get(0);
	}

	@Override
	public boolean deleteSelf(String selfId) { // 图书下架
		String sql = "delete from self where selfId=?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(selfId);
		return this.upadte(sql, lp);
	}

	@Override
	public List<Self> findAllBook() {
		List<Self> ls = null;
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from self";
		ls = this.query(sql, lp, Self.class);
		return ls;
	}

	@Override
	public List<Self> findBookBybookTypeId(int typeid, String bookname, String publisher, String author) {
		String sql = "select * from self where ";
		List<Self> selfList=null;
		BookTypeDao typeDao=new BookTypeDaoImpl();
		if (typeid != 0) {
			sql += "typeid=" + typeid;
		}else if (bookname != null) {
			sql += "bookname like '%" + bookname + "%'";
		}else if (publisher != null) {
			sql += "publisher like '%" + publisher + "%'";
		}else if (author != null) {
			System.out.println(author);
			sql += "author like '%" + author + "%'";
		}
		if(this.query(sql, new ArrayList<Object>(), Self.class).size()>0) {
			selfList=this.query(sql, new ArrayList<Object>(), Self.class);
			for(Self item:selfList) {
				System.out.println(item.getTypeId());
				item.setTypename(typeDao.findTypeById(item.getTypeId()).getName());
			}
		}
		return selfList;
	}

	@Override
	public boolean upBookNumber(String selfId, int bookNum) {
		List<Object> lp = new ArrayList<Object>();
		String sql = "update self set bookNum = ? where selfId = ?";
		lp.add(bookNum);
		lp.add(selfId);
		return this.upadte(sql, lp);
	}
}

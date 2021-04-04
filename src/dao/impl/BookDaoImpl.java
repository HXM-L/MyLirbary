package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.Borrrecord;
import dao.BookDao;
import dbc.BaseDao;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public boolean doBook(Book book) {	//ÃÌº”Õº È
		String sql="insert into book values(?,?,?)";
		List<Object> lp=new ArrayList<Object>();
		lp.add(book.getBookid());
		lp.add(book.getSelfid());
		lp.add(book.getBorrState());
		return this.upadte(sql, lp);
	}

	@Override
	public boolean deleteBook(String selfid) {	//…æ≥˝Õº È
		String sql="delete from book where selfid=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(selfid);
		return this.upadte(sql, lp);
	}

	
	@Override
	public boolean setBookStatus(String state,String selfid) {
		String sql="update book set borrState=? where selfid=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(state);
		lp.add(selfid);
		return this.upadte(sql, lp);
	}

	@Override
	public String findSelfId(String bookid) {
		List<Borrrecord> lb = null;
		List<Object> lp = new ArrayList<Object>();
		String sql = "select * from book where bookid="+bookid;
		Book book = (Book) this.query(sql, lp, Book.class).get(0);
		return book.getSelfid();
	}

}

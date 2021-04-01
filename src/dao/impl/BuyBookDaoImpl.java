package dao.impl;

import java.util.ArrayList;
import java.util.List;

import bean.BuyBook;
import dao.BuyBookDao;
import dbc.BaseDao;

public class BuyBookDaoImpl extends BaseDao implements BuyBookDao {

	@Override
	public boolean doBuyBook(BuyBook buyBook) {	//Ìí¼Ó²É¹ºµ¥
		String sql="insert into buybook values(?,?,?)";
		List<Object> lp=new ArrayList<Object>();
		lp.add(buyBook.getBuyBookId());
		lp.add(buyBook.getBookName());
		lp.add(buyBook.getPrice());
		lp.add(buyBook.getNum());
		lp.add(buyBook.getSelfId());
		lp.add(buyBook.getBuyDate());
		lp.add(buyBook.getSum());
		return this.upadte(sql, lp);
	}

	@Override
	public boolean modifyBuyBook(List<Object> list, String buyBookId) {
		String sql="update buybook set bookName=?,buyDate=?,price=?,num=?,selfId=?,buyDate=?,sum=? where=?";
		List<Object> lp=new ArrayList<Object>();
		for(int i=0;i<list.size();i++) {
			lp.add(list.get(i));
		}
		lp.add(buyBookId);
		return this.upadte(sql, lp);
	}

	@Override
	public boolean deleteBuyBook(String buyBookId) {
		String sql="delete from buybook where=?";
		List<Object> lp=new ArrayList<Object>();
		lp.add(buyBookId);
		return this.upadte(sql, lp);
	}

}

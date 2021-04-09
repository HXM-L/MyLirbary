package dao.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import bean.BookType;
import bean.BuyBook;
import dao.BuyBookDao;
import dbc.BaseDao;

public class BuyBookDaoImpl extends BaseDao implements BuyBookDao {

	@Override
	public boolean doBuyBook(BuyBook buyBook) { // 添加采购单
		String sql = "insert into buybook values(?,?,?)";
		List<Object> lp = new ArrayList<Object>();
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
	public boolean modifyBuyBook(BuyBook buyBook) {
		String sql = "update buybook set bookName=?,price=?,num=?,selfId=?,buyDate=?,sum=? where buyBookId = ?";
		List<Object> lp = new ArrayList<Object>();
		DecimalFormat decimalFormat = new DecimalFormat(".00");	//保留两位小数
		lp.add(buyBook.getBookName());
		lp.add(decimalFormat.format((float)buyBook.getPrice()));
		lp.add(buyBook.getNum());
		lp.add(buyBook.getSelfId());
		lp.add(buyBook.getBuyDate());
		lp.add(decimalFormat.format((float)buyBook.getSum()));
		lp.add(buyBook.getBuyBookId());
		return this.upadte(sql, lp);
	}

	@Override
	public boolean deleteBuyBook(String buyBookId) {
		String sql = "delete from buybook where buyBookId = ?";
		List<Object> lp = new ArrayList<Object>();
		lp.add(buyBookId);
		return this.upadte(sql, lp);
	}

	@Override
	public List<BuyBook> findAllBuyBook() {
		return this.query("select * from buybook", new ArrayList<Object>(), BuyBook.class);
	}

	@Override
	public BuyBook findRecordByID(String buyBookId) {
		return (BuyBook) this.query("select * from buybook where buyBookId=" + buyBookId, new ArrayList<Object>(), BuyBook.class).get(0);
	}

}

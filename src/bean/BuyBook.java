package bean;

public class BuyBook {	//采购图书清单表
	private String buyBookId;	//采购单号
	private String bookName;	//图书名
	private double price;	//图书单价
	private int num;	//图书数量
	private String selfId;	//图书所在书架id
	private String buyDate;	//采购日期
	private double sum;	//小计
	public BuyBook() {
		super();
	}
	public BuyBook(String buyBookId, String bookName, double price, int num, String selfId, String buyDate,
			double sum) {
		super();
		this.buyBookId = buyBookId;
		this.bookName = bookName;
		this.price = price;
		this.num = num;
		this.selfId = selfId;
		this.buyDate = buyDate;
		this.sum = sum;
	}
	public String getBuyBookId() {
		return buyBookId;
	}
	public void setBuyBookId(String buyBookId) {
		this.buyBookId = buyBookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSelfId() {
		return selfId;
	}
	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
}

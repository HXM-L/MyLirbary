package bean;

public class BuyBook {	//�ɹ�ͼ���嵥��
	private String buyBookId;	//�ɹ�����
	private String bookName;	//ͼ����
	private double price;	//ͼ�鵥��
	private int num;	//ͼ������
	private String selfId;	//ͼ���������id
	private String buyDate;	//�ɹ�����
	private double sum;	//С��
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

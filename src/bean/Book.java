package bean;

public class Book {	//ͼ����Ϣ��
	private String bookid;	//ͼ��id
	private String selfid;	//��ܺ�
	private String borrState;	//�ɽ���״̬
	public Book() {
		super();
	}
	public Book(String bookid, String selfid, String borrState) {
		super();
		this.bookid = bookid;
		this.selfid = selfid;
		this.borrState = borrState;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getSelfid() {
		return selfid;
	}
	public void setSelfid(String selfid) {
		this.selfid = selfid;
	}
	public String getBorrState() {
		return borrState;
	}
	public void setBorrState(String borrState) {
		this.borrState = borrState;
	}
	
}

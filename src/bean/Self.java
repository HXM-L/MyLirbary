package bean;

public class Self {	//��ܱ�
	private String selfId;	//ͼ���������id
	private String bookname;	//ͼ������
	private String author;	//ͼ��������
	private String publisherDate;	//��������
	private int bookNum;	//��ͼ�������
	private int typeId;	//ͼ�����ͱ��
	private String picture;	//ͼƬ·��
	private String introduction;	//ͼ����
	private String publisher;	//������
	public Self() {
		super();
	}
	
	public Self(String selfId, String bookname, String author, String publisherDate, int bookNum, int typeId,
			String picture, String introduction, String publisher) {
		super();
		this.selfId = selfId;
		this.bookname = bookname;
		this.author = author;
		this.publisherDate = publisherDate;
		this.bookNum = bookNum;
		this.typeId = typeId;
		this.picture = picture;
		this.introduction = introduction;
		this.publisher = publisher;
	}

	public String getSelfId() {
		return selfId;
	}
	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(String publisherDate) {
		this.publisherDate = publisherDate;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}

package bean;

public class Reserve { // Ԥ����
	private String reserveid; // Ԥ�����¼id
	private String bookid; // ͼ��id
	private String borowerId; // ������id
	private String reserveTime; // Ԥ��ʱ��
	private String fetchTime; // ȡ��ʱ��
	private String status; // ȡ��״̬
	private String bookName;//ͼ����

	public Reserve() {
		super();
	}

	public Reserve(String bookid, String borowerId, String reserveTime, String fetchTime, String status) {
		super();
		this.bookid = bookid;
		this.borowerId = borowerId;
		this.reserveTime = reserveTime;
		this.fetchTime = fetchTime;
		this.status = status;
	}

	public Reserve(String reserveid, String bookid, String borowerId, String reserveTime, String fetchTime, String status) {
		super();
		this.reserveid = reserveid;
		this.bookid = bookid;
		this.borowerId = borowerId;
		this.reserveTime = reserveTime;
		this.fetchTime = fetchTime;
		this.status = status;
	}

	public String getReserveid() {
		return reserveid;
	}

	public void setReserveid(String reserveid) {
		this.reserveid = reserveid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBorowerId() {
		return borowerId;
	}

	public void setBorowerId(String borowerId) {
		this.borowerId = borowerId;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(String fetchTime) {
		this.fetchTime = fetchTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}

package bean;

public class Reserve { // Ԥ����
	private int reserveid; // Ԥ�����¼id
	private String selfId; // ͼ��id
	private String borowerId; // ������id
	private String reserveTime; // Ԥ��ʱ��
	private String fetchTime; // ȡ��ʱ��
	private String status; // ȡ��״̬
	private String bookName;//ͼ����

	public Reserve() {
		super();
	}

	public Reserve(String selfId, String borowerId, String reserveTime, String fetchTime, String status) {
		super();
		this.selfId = selfId;
		this.borowerId = borowerId;
		this.reserveTime = reserveTime;
		this.fetchTime = fetchTime;
		this.status = status;
	}

	public Reserve(int reserveid, String selfId, String borowerId, String reserveTime, String fetchTime, String status) {
		super();
		this.reserveid = reserveid;
		this.selfId = selfId;
		this.borowerId = borowerId;
		this.reserveTime = reserveTime;
		this.fetchTime = fetchTime;
		this.status = status;
	}

	public int getReserveid() {
		return reserveid;
	}

	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}

	public String getselfId() {
		return selfId;
	}

	public void setselfId(String selfId) {
		this.selfId = selfId;
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

package bean;

public class Reserve { // 预定表
	private int reserveid; // 预定表记录id
	private String selfId; // 图书id
	private String borowerId; // 借阅人id
	private String reserveTime; // 预定时间
	private String fetchTime; // 取书时间
	private String status; // 取书状态
	private String bookName;//图书名

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

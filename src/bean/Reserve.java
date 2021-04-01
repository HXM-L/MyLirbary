package bean;

public class Reserve { // 预定表
	private String reserveid; // 预定表记录id
	private String bookid; // 图书id
	private String borowerId; // 借阅人id
	private String reserveTime; // 预定时间
	private String fetchTime; // 取书时间
	private String status; // 取书状态

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

	public String getreserveid() {
		return reserveid;
	}

	public void setreserveid(String reserveid) {
		this.reserveid = reserveid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getborowerId() {
		return borowerId;
	}

	public void setborowerId(String borowerId) {
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

}

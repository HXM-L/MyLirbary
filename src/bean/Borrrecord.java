package bean;

public class Borrrecord { // ���ļ�¼��
	private String borrRecordId; // ��¼id(ϵͳ��ǰ+ʱ��ʱ����)
	private String borrowerId; // ������id
	private String returnFlag; // �軹��־
	private String bookid; // ͼ��id
	private String borrTime; // ��������
	private String returnTime; // �黹����
	private String aginBorr; // �����־
	private String overTime; // ���ڱ�־
	private String bookName; // ͼ����

	public Borrrecord() {
		super();
	}

	public Borrrecord(String borrRecordId, String borrowerId, String returnFlag, String bookid, String borrTime,
			String returnTime, String aginBorr, String overTime, String bookName) {
		super();
		this.borrRecordId = borrRecordId;
		this.borrowerId = borrowerId;
		this.returnFlag = returnFlag;
		this.bookid = bookid;
		this.borrTime = borrTime;
		this.returnTime = returnTime;
		this.aginBorr = aginBorr;
		this.overTime = overTime;
		this.bookName = bookName;
	}

	public String getBorrRecordId() {
		return borrRecordId;
	}

	public void setBorrRecordId(String borrRecordId) {
		this.borrRecordId = borrRecordId;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBorrTime() {
		return borrTime;
	}

	public void setBorrTime(String borrTime) {
		this.borrTime = borrTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getAginBorr() { // https://blog.csdn.net/GeekYoung/article/details/81509894
		return aginBorr;
	}

	public void setAginBorr(String aginBorr) {
		this.aginBorr = aginBorr;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}

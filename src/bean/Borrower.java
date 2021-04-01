package bean;

public class Borrower { // ��������Ϣ��
	private String borrowerId; // ͼ��֤id
	private String name; // ����������
	private String password; // ����
	private String remarks; // ��ע��Ϣ
	private String phone; // �绰
	private double money; // ���
	private int num; // ʣ��ɽ�������
	private String status; // �˺�״̬(����/����)
	private int identityId; // ������ͱ��

	public Borrower() {
		super();
	}

	public Borrower(String name, String password, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public Borrower(String borrowerId, String name, String password, String remarks, String phone, double money,
			int num, String status, int identityId) {
		super();
		this.borrowerId = borrowerId;
		this.name = name;
		this.password = password;
		this.remarks = remarks;
		this.phone = phone;
		this.money = money;
		this.num = num;
		this.status = status;
		this.identityId = identityId;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdentityId() {
		return identityId;
	}

	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
}

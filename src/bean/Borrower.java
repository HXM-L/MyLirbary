package bean;

public class Borrower { // 借阅人信息表
	private String borrowerId; // 图书证id
	private String name; // 借阅人姓名
	private String password; // 密码
	private String remarks; // 备注信息
	private String phone; // 电话
	private double money; // 金额
	private int num; // 剩余可借阅数量
	private String status; // 账号状态(正常/冻结)
	private int identityId; // 身份类型编号

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

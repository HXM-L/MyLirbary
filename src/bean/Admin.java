package bean;

public class Admin {	//����Ա��Ϣ��
	private int id;	//����Աid
	private String name;	//����Ա�ǳ�
	private String password;	//����Ա����
	private String phone;	//��ϵ�绰
	
	public Admin() {
		super();
	}
	public Admin(int id, String name, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

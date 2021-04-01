package bean;

public class Identity {	//借阅人身份类型
	private int identityId;	//身份类型编号
	private String name;	//身份类型名
	public Identity() {
		super();
	}
	public Identity(int identityId, String name) {
		super();
		this.identityId = identityId;
		this.name = name;
	}
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

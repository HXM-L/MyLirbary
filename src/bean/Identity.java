package bean;

public class Identity {	//�������������
	private int identityId;	//������ͱ��
	private String name;	//���������
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

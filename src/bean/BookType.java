package bean;

public class BookType {	//ͼ�����ͱ�
	private int typeId;	//ͼ������id
	private String name;	//��������
	public BookType() {
		super();
	}
	public BookType(int typeId, String name) {
		super();
		this.typeId = typeId;
		this.name = name;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

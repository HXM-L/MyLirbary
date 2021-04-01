package bean;

public class BookType {	//图书类型表
	private int typeId;	//图书类型id
	private String name;	//类型名称
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

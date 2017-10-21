package model;

public class Image {

	private String id;
	private String type;
	private int height;
	private String category;
	public Image(String id, String type, int height, String category) {
		super();
		this.id = id;
		this.type = type;
		this.height = height;
		this.category = category;
	}
	
	public Image() {
		this("","",0,"");
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}

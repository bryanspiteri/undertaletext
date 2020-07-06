package github.hyblocker.undertaletext.objects;

public class Item {
	
	public int id;
	public String fullName,shortName,seriousName,description;
	
	public Item(int id, String fullName, String battleName) {
		this.id=id;
		this.fullName=fullName;
		shortName=battleName;
	}
	
	public int getID() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getFullname() {
		return fullName;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String getSeriousName() {
		return seriousName;
	}
	
	public void use() {
		
	}
	
	public void drop() {
		
	}
}

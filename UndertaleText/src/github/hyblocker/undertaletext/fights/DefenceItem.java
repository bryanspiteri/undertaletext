package github.hyblocker.undertaletext.fights;

import github.hyblocker.undertaletext.objects.Item;

public class DefenceItem extends Item {
	public int id, DEF;
	public String fullName,shortName,seriousName,description;
	
	public DefenceItem(int id, String fullName, String battleName, int defence) {
		super(id,fullName,battleName);
		this.id=id;
		this.fullName=fullName;
		shortName=battleName;
		DEF=defence;
	}
	
	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void use() {
		
	}
	
	@Override
	public void drop() {
		
	}
	
	@Override
	public String getFullname() {
		return fullName;
	}
	
	@Override
	public String getShortName() {
		return shortName;
	}
	
	@Override
	public String getSeriousName() {
		return seriousName;
	}
}

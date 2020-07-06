package github.hyblocker.undertaletext.fights;

import github.hyblocker.undertaletext.objects.Item;

public class WeaponItem extends Item {
	public int id, WeaponATK;
	public String fullName,shortName,seriousName,description;
	
	public WeaponItem(int id, String fullName, String battleName, int damage) {
		super(id,fullName,battleName);
		this.id=id;
		this.fullName=fullName;
		shortName=battleName;
		WeaponATK=damage;
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

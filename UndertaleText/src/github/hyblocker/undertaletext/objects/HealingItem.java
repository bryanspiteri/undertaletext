package github.hyblocker.undertaletext.objects;

public class HealingItem extends Item {

	public int id, HPtoHeal;
	public String fullName,shortName,seriousName,description;
	
	public HealingItem(int id, String fullName, String battleName, int hpToHeal) {
		super(id,fullName,battleName);
		this.id=id;
		this.fullName=fullName;
		shortName=battleName;
		HPtoHeal=hpToHeal;
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

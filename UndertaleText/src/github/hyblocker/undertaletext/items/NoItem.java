package github.hyblocker.undertaletext.items;

import github.hyblocker.undertaletext.objects.Item;
import github.hyblocker.undertaletext.other.Game;

/*
 * Pretty much the 'null' item.
 */
public class NoItem extends Item{
	
	public int slot = 0;
	
	public NoItem(int id, String fullName, String battleName, int slot) {
		super(id,fullName,battleName);
		this.slot=slot;
	}
	public NoItem(int slot) {
		super(0,"","");
		this.slot=slot;
	}
	
	@Override
	public int getID() {
		return 0;
	}
	
	@Override
	public String getDescription() {
		return "";
	}
	
	
	@Override
	public String getFullname() {
		return "";
	}
	
	@Override
	public String getShortName() {
		return "";
	}
	
	@Override
	public String getSeriousName() {
		return "";
	}
	
	@Override
	public void use() {
		
	}
	
	@Override
	public void drop() {
		
	}
}

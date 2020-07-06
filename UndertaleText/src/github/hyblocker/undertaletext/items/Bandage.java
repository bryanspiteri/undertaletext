package github.hyblocker.undertaletext.items;

import github.hyblocker.undertaletext.fights.WeaponItem;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Dialog;
import github.hyblocker.undertaletext.util.ItemHandler;

public class Bandage extends WeaponItem{
	
	public int id = 11;
	public int slot = 0;
	public String fullName = "Bandage";
	public String shortName = "Bandage";
	public String seriousName="Bandage";
	public String description="All HP Butterscotch-cinnamon pie, one slice.";
	
	public Bandage(int id, String fullName, String battleName, int slot) {
		super(id,fullName,battleName,Game._inst.plrData.MaxHP);
		this.slot=slot;
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
	
	@Override
	public void use() {
		Game._inst.plrData.inventory[slot]=Game._inst.plrData.inventory[0];
		Game._inst.plrData.inventory[slot]=this;
		Dialog.Speak("* You've equipped the Bandage");
	}
	
	@Override
	public void drop() {
		try {
			Game._inst.plrData.inventory[slot]=ItemHandler.getNullItem(slot);
		}catch(Exception ex) {
			System.err.println("ArrayOutOfBoundsException: Failed to drop "+this.getFullname()+" (ID: "+id+")!");
		}
	}
}

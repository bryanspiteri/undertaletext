package github.hyblocker.undertaletext.items;

import github.hyblocker.undertaletext.objects.HealingItem;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Dialog;

public class ButterscotchPie extends HealingItem{
	
	public int id = 11;
	public int slot = 0;
	public String fullName = "Butterscotch Pie";
	public String shortName = "ButtsPie";
	public String seriousName="Pie";
	public String description="All HP Butterscotch-cinnamon pie, one slice.";
	
	public ButterscotchPie(int id, String fullName, String battleName, int slot) {
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
		Game._inst.plrData.CurrentHP = Game._inst.plrData.MaxHP;
		drop();
		Dialog.Speak("* You ate the pie.&&HP fully restored.");
	}
	
	@Override
	public void drop() {
		try {
		Game._inst.plrData.inventory[slot]=null;
		}catch(Exception ex) {
			System.err.println("ArrayOutOfBoundsException: Failed to drop "+this.getFullname()+" (ID: "+id+")!");
		}
	}
}

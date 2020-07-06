package github.hyblocker.undertaletext.fights;

import github.hyblocker.undertaletext.util.Vector2;

public class Fight {
	
	public String BLACK = "¼";
	public String BLACK_LINE = "¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼";
	public enum FineTunedPosition{
		TopLeft,
		TopMiddle,
		TopRight,
		CenterLeft,
		CenterMiddle,
		CenterRight,
		BottomLeft,
		BottomMiddle,
		BottomRight
	};
	
	public String[] soulLocations = {
		"Α",
		"Β",
		"Γ",
		"Δ",
		"Ε",
		"Ζ",
		"Η",
		"Θ",
		"Ι"
	};
	
	public String[] Buttons = {
		"", //FIGHT
		"", //ACT
		"", //ITEM
		"", //MERCY
		"", //FIGHT SELECTED
		"", //ACT   SELECTED
		"", //ITEM  SELECTED
		"", //MERCY SELECTED
	};
	
	public Vector2 pos = Vector2.zero;
	public FineTunedPosition loc = FineTunedPosition.CenterMiddle;
	
	public void OnTick() {
		
	}
}

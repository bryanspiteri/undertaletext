package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Vector2;

public class FloweyStartArea extends Entity {
	String[] GFX = {
		"�",
		"�"
	};
	
	String[] dialog = {
			"",
			"",
			"",
	};
	
	boolean isTalking=false;
	
	
	
	public FloweyStartArea() {
		
	}
	
	@Override
	public Vector2 getPosition() {
		return new Vector2(8,15);
	}
	
	@Override
	public String getSprite() {
		return GFX[0];
	}
	
	@Override
	public void OnTick(Player thisPlayer){
		Vector2 playerPos = new Vector2(thisPlayer.playerPosX,thisPlayer.playerPosY);
	}
}

package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Vector2;

public class NPC extends Entity {
	
	public String[] sprites = new String[1];
	
	public String[] dialog = {"Oops. The dialog isn't&loading. You should contact the&developer."};
	
	public Vector2 position = Vector2.zero;
	
	public NPC(String[] sprites, String[] dialog, Vector2 pos) {
		position=pos;
		this.sprites=sprites.clone();
		this.dialog=dialog.clone();
	}
	
	@Override
	public boolean hasCollider() {
		return true;
	}
	
	@Override
	public String getSprite(){
		return sprites[1];
	}
	
	@Override
	public void OnTick(Player thisPlayer) {
		
	}
}

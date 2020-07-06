package github.hyblocker.undertaletext.npcs.toriel;

import github.hyblocker.undertaletext.objects.NPC;
import github.hyblocker.undertaletext.util.Vector2;

public class TorielBase extends NPC {

	public Vector2 position = Vector2.zero;
	
	public TorielBase(String[] sprites, String[] dialog, Vector2 pos) {
		super(sprites, dialog, pos);
		position=pos;
	}
	
	public String[] sprites = {
			
	};
	
	@Override
	public boolean hasCollider() {
		return true;
	}
	
	@Override
	public Vector2 getPosition(){
		return position;
	}
	
	@Override
	public String getSprite(){
		return sprites[0];
	}
}

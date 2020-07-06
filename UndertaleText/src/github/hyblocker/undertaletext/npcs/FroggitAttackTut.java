package github.hyblocker.undertaletext.npcs;

import github.hyblocker.undertaletext.objects.NPC;
import github.hyblocker.undertaletext.util.Vector2;

public class FroggitAttackTut extends NPC {

	public static String[] sprites = {""};
	public static String[] dialog = {""};
	public Vector2 position;
	
	public FroggitAttackTut(Vector2 position) {
		super(sprites, dialog, position);
		this.position=position;
	}
	
	@Override
	public boolean hasCollider() {
		return true;
	}
	
	
}

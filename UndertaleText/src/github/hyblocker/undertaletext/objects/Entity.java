package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Vector2;

public abstract class Entity {
	
	public Vector2 getPosition() {
		return Vector2.zero;
	}
	
	public String getSprite() {
		return "";
	}
	
	public void OnTick(Player thisPlayer) {
		
	}
	
	public boolean hasCollider() {
		return false;
	}
}

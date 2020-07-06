package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Vector2;

public class SpikeTrap extends Entity {

	boolean state = false;
	
	Vector2 position = Vector2.zero;
	
	public SpikeTrap(Vector2 position, boolean initialState) {
		this.position=position;
		this.state=initialState;
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public boolean hasCollider() {
		return state;
	}
	
	@Override
	public String getSprite() {
		if(state==true) {
			return "Ʀ";
		}else {
			return "Ƨ";
		}
	}
	
	public void setState(boolean state) {
		this.state=state;
	}
}

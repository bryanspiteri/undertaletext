package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Vector2;

public class TorMarking extends Entity {
	
	public boolean markings=false;
	
	//ơ Ƣƣ Ƥƥ
	
	Vector2 position = Vector2.zero;
	
	public TorMarking(Vector2 position,boolean markings) {
		this.position = position;
		this.markings=markings;
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public String getSprite() {
		//System.out.println(markings);
		if(markings==true) {
			return "ơ";
		}else {
			return "æ";
		}
	}
	
	@Override
	public boolean hasCollider() {
		return true;
	}
}

package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Facing;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class TorSwitch extends Entity {
	
	public boolean state=false;
	public boolean markings=false;
	public boolean canActivate=false;
	public boolean activateOnce=false;
	public boolean makeSound=true;
	
	private boolean activatedOnce=false;
	
	//ơ Ƣƣ Ƥƥ
	
	Vector2 position = Vector2.zero;
	
	public TorSwitch(Vector2 position, boolean markings, boolean canActivate, boolean initState, boolean activateOnce,boolean makeSound) {
		this.position=position;
		this.markings=markings;
		this.canActivate=canActivate;
		this.activateOnce=activateOnce;
		this.makeSound=makeSound;
		this.state=initState;
	}
	
	public TorSwitch(Vector2 position,boolean markings, boolean canActivate) {
		this.position = position;
		this.markings=markings;
		this.canActivate=canActivate;
	}
	
	public TorSwitch(Vector2 position,boolean markings) {
		this.position = position;
		this.markings=markings;
		this.canActivate=true;
	}
	
	public boolean isActivated(){
		return this.state;
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public String getSprite() {
		//System.out.println(markings);
		if(markings==true) {
			if(state==true) {
				return "Ƣ";
			}else {
				return "ƣ";
			}
		}else {
			if(state==true) {
				return "Ƥ";
			}else {
				return "ƥ";
			}
		}
	}
	
	@Override
	public void OnTick(Player thisPlayer) {
		if(Input.GetKey(KeyCode.Z)||Input.GetKey(KeyCode.Enter)) {
			
			Vector2 pos = new Vector2(thisPlayer.playerPosX,thisPlayer.playerPosY);
			Facing facing = thisPlayer.dir;
			
			if(pos.x==position.x+1 && pos.x==position.y && facing==Facing.LEFT) {
				activateSwitch(thisPlayer);
			}
			else if(pos.x==position.x-1 && pos.x==position.y && facing==Facing.RIGHT) {
				activateSwitch(thisPlayer);
			}
			else if(pos.y==position.y-1 && pos.x==position.x && facing==Facing.DOWN) {
				activateSwitch(thisPlayer);
			}
			else if(pos.y==position.y+1 && pos.x==position.x && facing==Facing.UP) {
				activateSwitch(thisPlayer);
			}
		}
	}
	
	@Override
	public boolean hasCollider() {
		return true;
	}
	/*
	 * Use this externally
	 */
	public void ActivateSwitch(Player thisPlayer) {
		state=!state;
		if(makeSound==true) {
			Audio.PlayOneShot("snd_switchpull_n");
		}
		thisPlayer.Draw(thisPlayer);
	}
	
	public void activateSwitch(Player thisPlayer) {
		if(canActivate==true) {
			if(activateOnce==true) {
				if(activatedOnce==false) {
					activatedOnce=true;
					ActivateSwitch(thisPlayer);
				}
			}else {
				ActivateSwitch(thisPlayer);
			}
		}
	}
}

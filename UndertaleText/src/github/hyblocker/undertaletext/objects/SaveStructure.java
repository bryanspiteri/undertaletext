package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Animation;
import github.hyblocker.undertaletext.util.AnimationController;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Facing;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class SaveStructure extends Entity {
	
	String[] message = new String[1];
	String location = "RUINS";
	
	String[] sprites = {
		"è",
		"é"
	};
	
	Vector2 position = Vector2.zero;
	
	public AnimationController animator;
	
	public SaveStructure(String[] message,String location, Vector2 position) {
		this.message=message.clone();
		this.location=location;
		this.position=position;
		Animation anim = new Animation(sprites, 1, true);
		animator = new AnimationController();
		animator.RegisterAnimation(anim, "base");
	}
	
	int frame=0;
	
	@Override
	public boolean hasCollider() {
		return true;
	}
	
	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public String getSprite() {
		
		return animator.GetGFX();
		//return sprites[frame];
	}
	
	@Override
	public void OnTick(Player thisPlayer) {
		//frame++;
		//if(frame<0||2<=frame) {
		//	frame=0;
		//}
		animator.Tick();
		thisPlayer.Draw(thisPlayer);
		if(Input.GetKey(KeyCode.Z)||Input.GetKey(KeyCode.Enter)) {
			//If player is next to the save structure and is facing towards it.
			
			Vector2 pos = new Vector2(thisPlayer.playerPosX,thisPlayer.playerPosY);
			Facing facing = thisPlayer.dir;
			
			if(pos.x==position.x+1 && pos.x==position.y && facing==Facing.LEFT) {
				thisPlayer.canMove=false;
				saveDialog(thisPlayer);
			}
			else if(pos.x==position.x-1 && pos.x==position.y && facing==Facing.RIGHT) {
				thisPlayer.canMove=false;
				saveDialog(thisPlayer);
			}
			else if(pos.y==position.y-1 && pos.x==position.x && facing==Facing.DOWN) {
				thisPlayer.canMove=false;
				saveDialog(thisPlayer);
			}
			else if(pos.y==position.y+1 && pos.x==position.x && facing==Facing.UP) {
				thisPlayer.canMove=false;
				saveDialog(thisPlayer);
			}
		}
	}
	
	public void saveDialog(Player thisPlayer) {
		Audio.PlayOneShot("snd_SAVEpoint");
		
		thisPlayer.canMove=true;
	}
}

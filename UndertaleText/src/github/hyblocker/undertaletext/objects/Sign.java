package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.util.Dialog;
import github.hyblocker.undertaletext.util.Facing;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class Sign extends NPC {
	
	public String[] dialog = {"Oops. The dialog isn't#loading. You should contact the#developer."};
	public String[] dialog2 = dialog.clone();
	
	public boolean talkedOnce=false;
	
	public Vector2 position = Vector2.zero;
	
	/*
	* dialog is the first one, after you talked once (dialog1) , dialog2 is shown infinetely
	*/ 
	public Sign(String[] sprites, String[] dialog, String[] dialog2, Vector2 pos) {
		super(sprites,dialog,pos);
		position=pos;
		this.sprites=sprites.clone();
		this.dialog=dialog.clone();
		this.dialog2=dialog2.clone();
	}
	
	public Sign(String[] sprites, String[] dialog, Vector2 pos) {
		super(sprites,dialog,pos);
		position=pos;
		this.sprites=sprites.clone();
		this.dialog=dialog.clone();
		this.dialog2=dialog.clone();
	}
	
	@Override
	public boolean hasCollider() {
		return false;
	}
	
	@Override
	public String getSprite(){
		return "";
	}
	
	public void setDialog1Text(String[] txt1) {
		this.dialog=txt1.clone();
	}
	public void setDialog2Text(String[] txt2) {
		this.dialog2=txt2.clone();
	}
	
	@Override
	public void OnTick(Player thisPlayer) {
		if(Input.GetKey(KeyCode.Z)||Input.GetKey(KeyCode.Enter)) {
			//If player is next to the save structure and is facing towards it.
			
			Vector2 pos = new Vector2(thisPlayer.playerPosX,thisPlayer.playerPosY);
			Facing facing = thisPlayer.dir;
			
			if(pos.x==position.x+1 && pos.x==position.y && facing==Facing.LEFT) {
				thisPlayer.canMove=false;
				Talk(thisPlayer);
			}
			else if(pos.x==position.x-1 && pos.x==position.y && facing==Facing.RIGHT) {
				thisPlayer.canMove=false;
				Talk(thisPlayer);
			}
			else if(pos.y==position.y-1 && pos.x==position.x && facing==Facing.DOWN) {
				thisPlayer.canMove=false;
				Talk(thisPlayer);
			}
			else if(pos.y==position.y+1 && pos.x==position.x && facing==Facing.UP) {
				thisPlayer.canMove=false;
				Talk(thisPlayer);
			}
		}
	}
	
	public void Talk(Player thisPlayer){
		if(talkedOnce==false) {
			talkedOnce=true;
			Dialog.Speak(Dialog.empty, dialog, "snd_talkdefault",0.25f);
		}else {
			Dialog.Speak(Dialog.empty, dialog2, "snd_talkdefault",0.25f);
		}
	}
}

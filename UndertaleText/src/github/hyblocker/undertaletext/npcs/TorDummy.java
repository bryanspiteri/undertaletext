package github.hyblocker.undertaletext.npcs;

import github.hyblocker.undertaletext.enemies.Dummy.Dummy;
import github.hyblocker.undertaletext.fights.Fight;
import github.hyblocker.undertaletext.objects.NPC;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Facing;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.OggClip;
import github.hyblocker.undertaletext.util.Vector2;

public class TorDummy extends NPC {
	
	public String[] sprites = {
		"Ơ", // overworld dummy sprite
		" ",
	};
	
	public String[] dialog = {""};
	
	public Vector2 position = Vector2.zero;
	public boolean dummyGone=false;
	
	public TorDummy(String[] sprites, String[] dialog, Vector2 pos) {
		super(sprites,dialog,pos);
		position=pos;
	}
	
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
		if(dummyGone==true) {
			return sprites[1];
		}else {
			return sprites[0];
		}
	}
	
	@Override
	public void OnTick(Player thisPlayer) {
		if(Game._inst.isInFight==false) {
			if(Input.GetKey(KeyCode.Z)||Input.GetKey(KeyCode.Enter)) {			
				Vector2 pos = new Vector2(thisPlayer.playerPosX,thisPlayer.playerPosY);
				Facing facing = thisPlayer.dir;
					
				if(pos.x==position.x+1 && pos.x==position.y && facing==Facing.LEFT) {
					TriggerDummyFight(thisPlayer);
				}
				else if(pos.x==position.x-1 && pos.x==position.y && facing==Facing.RIGHT) {
					TriggerDummyFight(thisPlayer);
				}
				else if(pos.y==position.y-1 && pos.x==position.x && facing==Facing.DOWN) {
					TriggerDummyFight(thisPlayer);
				}
				else if(pos.y==position.y+1 && pos.x==position.x && facing==Facing.UP) {
					TriggerDummyFight(thisPlayer);
				}
			}
		}
	}
	
	public void TriggerDummyFight(Player thisPlayer){
		if(dummyGone==false) {
			thisPlayer.canMove=false;
			Game._inst._currFight = new Dummy(thisPlayer);
			String[] prevScreen = GameRenderer.prevDraw.clone();
			String[] BLACKSCREEN = {
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
					new Fight().BLACK_LINE,
				};
			Game._inst.isInFight=true;
			long delay=(long) (500/Game.gameTick);
			OggClip introSFX = Audio.MakeSound("snd_b");
			BLACKSCREEN[(int) thisPlayer.renderPos.y]=BLACKSCREEN[(int) thisPlayer.renderPos.y].substring(0, (int) thisPlayer.renderPos.x-1)+"Ε"+BLACKSCREEN[(int) thisPlayer.renderPos.y].substring((int) thisPlayer.renderPos.x);
			GameRenderer.Draw(BLACKSCREEN);
			//introSFX.play();
			try{Thread.sleep(delay);}catch(Exception ex) {}
			GameRenderer.Draw(prevScreen);
			//introSFX.stop();
			try{Thread.sleep(delay);}catch(Exception ex) {}
			GameRenderer.Draw(BLACKSCREEN);
			//introSFX.play();
			try{Thread.sleep(delay);}catch(Exception ex) {}
			GameRenderer.Draw(prevScreen);
			//introSFX.stop();
			try{Thread.sleep(delay);}catch(Exception ex) {}
			GameRenderer.Draw(BLACKSCREEN);
			Audio.PlayOneShot("snd_battlefall");
			
		}
		thisPlayer.canMove=true;
	}
}

package github.hyblocker.undertaletext.rooms.special;

import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class GameOver extends Room {
	public GameOver(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	public String BLACK = "¼";

	public String[] GAMEOVER = {
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
	};
	
	@Override
	public void BeginRoom(Vector2 pos) {
		
	}
	
	@Override
	public void OnTick(){
		if(Input.GetKey(KeyCode.Z)) {
			
		}
	}
}

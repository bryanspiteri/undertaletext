package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class Room extends Game {
	public static int width=16;
	public static int height=12;
	
	public static final int renderX = 16;
	public static final int renderY = 12;
	
	public static int camPosX = 4;
	public static int camPosY = 4;

	public static int playerPosX = 5;
	public static int playerPosY = 6;
	
	public static boolean TopDownMode=true;
	
	public static String[] room = {
			
	};
	
	public static String[] collider = {
			
	};
	
	public Room(int widt,int heght,int plrPosX,int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		width=widt;
		height=heght;
		playerPosX=plrPosX;
		playerPosY=plrPosY;
		room=Room.clone();
		collider=Collider.clone();
		TopDownMode=topdown;
	}
	
	public void BeginRoom(Vector2 pos){
		
	}
	
	public void OnTick() {
		
	}
	
	public String[] GetGraphics() {
		return new String[1];
	}
	
	public String[] GetColliders() {
		return new String[1];
	}
}

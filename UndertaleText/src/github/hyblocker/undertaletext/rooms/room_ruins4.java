package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.npcs.TorDummy;
import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Dialog;
import github.hyblocker.undertaletext.util.Vector2;

public class room_ruins4 extends Room{

	public static int width=16;
	public static int height=12;

	public static int playerPosX = 6;
	public static int playerPosY = 6;
	
	Player thisPlayer;
	
	public static Teleporter tp0,tp1;    
	public static Teleporter tpR0,tpR1;   
	
	public static TorDummy dummy;
	
	// ûüýþḀḁḂḃḄḅḝḞḟḠ
	public static String[] Graphics = {
		"¼¼¼ḟḂḂü¼¼ûḂḂḠ¼¼¼",
		"¼¼ḟüããä¼¼âããûḠ¼¼", 
		"¼ḟüäããä¼¼âããâûḠ¼",
		"Ḃüääææç¼¼åææââḅ¼",
		"ãääç        åâḅ¼", 
		"ãäç          åḅ¼", 
		"æç            ḅ¼", 
		"              ḅ¼", 
		"              ḅ¼", 
		"ḄḄþ          ýḝ¼", 
		"¼¼Ḟþ        ýḝ¼¼", 
		"¼¼¼ḞḄḄḄḄḄḄḄḄḝ¼¼¼",
	};
	
	public static String[] Colliders = {
		"################",
		"################",
		"################",
		"################",
		"####        ####",
		"###          ###",
		"##            ##",
		"              ##",
		"              ##",
		"###          ###",
		"####        ####",
		"################",
	};

	public room_ruins4(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public String[] GetGraphics() {
		return Graphics.clone();
	}
	
	@Override
	public String[] GetColliders() {
		return Colliders.clone();
	}
	
	@Override
	public void BeginRoom(Vector2 pos){
		thisPlayer= new Player(width,height,playerPosX,playerPosY,Graphics,Colliders);
		Game._inst.plr=thisPlayer;
		tp0 = new Teleporter(new room_ruins3(16, 21, 7, 19, room_ruins3.Graphics, room_ruins3.Colliders, true),new Vector2(1,7),new Vector2(36,7));
		tp1 = new Teleporter(new room_ruins3(16, 21, 7, 19, room_ruins3.Graphics, room_ruins3.Colliders, true),new Vector2(1,8),new Vector2(36,8));
		//tpR0 = new Teleporter(new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),new Vector2(8,3),new Vector2(8,18));
		//tpR1 = new Teleporter(new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),new Vector2(9,3),new Vector2(8,18));
		dummy = new TorDummy(Dialog.empty, Dialog.empty, new Vector2(11,5));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tp0);
		thisPlayer.entities.add(tp1);
		thisPlayer.entities.add(dummy);
		thisPlayer.playerPosX=(int)pos.x;
		thisPlayer.playerPosY=(int)pos.y;
		thisPlayer.BeginRoom();
	}
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			if(dummy!=null) {
				dummy.OnTick(thisPlayer);
			}
			if(tp0!=null) {
				tp0.OnTick(thisPlayer);
			}
			if(tp1!=null) {
				tp1.OnTick(thisPlayer);
			}
			//tp0.OnTick(thisPlayer);
			//System.out.println("Position: "+thisPlayer.playerPosX+", "+thisPlayer.playerPosY);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}
}

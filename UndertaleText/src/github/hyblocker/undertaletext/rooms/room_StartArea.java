package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class room_StartArea extends Room{

	/*if(test==7 && playerPosX==31) {
		System.out.println("NEXT ROOM");
	}*/
	
	public static int width=33;
	public static int height=13;

	public static int playerPosX = 8;
	public static int playerPosY = 6;
	
	Player thisPlayer;
	
	public static Teleporter tpToST1,tpToST2;    
	
	public static String[] Graphics = {
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼ÚÔ      ÕÛ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƞƟ¼¼",
		"¼Ô          Õ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƚƛƜƝ¼",
		"¼            ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƔƖ¼Ƙ¼",
		"¼     ÜÝÞ    ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼Ɣƕ¼Ɨ¼",
		"¼     ßàá    Û¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƐƑƒƓ¼",
		"¼×                              ¼",
		"¼Ù×                            Ö¼",
		"¼¼Ù×      ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼Ù×    ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼"
			
	};
	
	public static String[] Colliders = {
		"#################################",
		"#################################",
		"#################################",
		"###        ######################",
		"#            ####################",
		"#            ####################",
		"#            ####################",
		"#            ####################",
		"#                               #",
		"##                              #",
		"###        ######################",
		"####      #######################",
		"#################################"
	};

	public room_StartArea(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
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
		tpToST1 = new Teleporter(new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),new Vector2(30,7),new Vector2(8,18));
		tpToST2 = new Teleporter(new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),new Vector2(31,7),new Vector2(8,18));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tpToST1);
		thisPlayer.entities.add(tpToST2);
		thisPlayer.BeginRoom();
	}
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			tpToST1.OnTick(thisPlayer);
			tpToST2.OnTick(thisPlayer);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}
}

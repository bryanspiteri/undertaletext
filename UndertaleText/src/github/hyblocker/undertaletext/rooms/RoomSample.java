package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class RoomSample extends Room{

	public static int width=33;
	public static int height=13;

	public static int playerPosX = 6;
	public static int playerPosY = 6;
	
	Player thisPlayer;
	
	public static Teleporter tpToST2;    
	
	public static String[] Graphics = {
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼ÚÔ       ÕÛ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƞƟ¼¼",
		"¼Ô          Õ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƚƛƜƝ¼",
		"¼            ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƔƖ¼Ƙ¼",
		"¼    ÜÝÞ     Û¼¼¼¼¼¼¼¼¼¼¼¼¼¼Ɣƕ¼Ɨ¼",
		"¼    ßàá     ÕÛ¼¼¼¼¼¼¼¼¼¼¼¼¼ƐƑƒƓ¼",
		"¼×                              ¼",
		"¼Ù×                            Ö¼",
		"¼¼Ù×         ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼Ù×       ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼"
			
	};
	
	public static String[] Colliders = {
		"#################################",
		"#################################",
		"#################################",
		"###         #####################",
		"##           ####################",
		"#            ####################",
		"#            ####################",
		"#             ###################",
		"#                               #",
		"##                              #",
		"###           ###################",
		"####         ####################",
		"#################################"
	};

	public RoomSample(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
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
	public void BeginRoom(Vector2 inPos){
		thisPlayer= new Player(width,height,playerPosX,playerPosY,Graphics,Colliders);
		Game._inst.plr=thisPlayer;
		tpToST2 = new Teleporter(new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),new Vector2(31,7),new Vector2(8,18));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tpToST2);
		thisPlayer.BeginRoom();
	}
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			tpToST2.OnTick(thisPlayer);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}
}

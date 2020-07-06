package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.FloweyStartArea;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class room_StartArea2 extends Room{

	/*if(test==7 && playerPosX==31) {
		System.out.println("NEXT ROOM");
	}*/
	
	public static int width=16;
	public static int height=21;

	public static int playerPosX = 8;
	public static int playerPosY = 18;

	public static Teleporter tp0,tp1,tp2,tp3;
	public static Teleporter tpR0,tpR1,tpR2,tpR3;
	public static FloweyStartArea flowey;
	
	Player thisPlayer;    
	
	//MEGA GFX
	//ÔÕÖ×ØÙÚÛÜÝÞßáàâãäåæç  ƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠ
	
	public static String[] Graphics = {
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼ƞƟ¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼ƚƛƜƝ¼¼¼¼¼¼",
		"¼¼¼¼¼¼ƔƖ¼Ƙ¼¼¼¼¼¼",
		"¼¼¼¼¼¼Ɣƕ¼Ɨ¼¼¼¼¼¼",
		"¼¼¼¼¼¼ƐƑƒƓ¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼"
		
	};
	
	public static String[] Colliders = {
		"################",
		"################",
		"################",
		"################",
		"################",
		"################",
		"######    ######",
		"####        ####",
		"##            ##",
		"#              #",
		"#              #",
		"#              #",
		"#              #",
		"#              #",
		"#              #",
		"##            ##",
		"###          ###",
		"#####      #####",
		"######    ######",
		"######    ######"
	};
	
	@Override
	public String[] GetGraphics() {
		return Graphics;
	}
	
	@Override
	public String[] GetColliders() {
		return Colliders;
	}

	public room_StartArea2(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public void BeginRoom(Vector2 pos){
		thisPlayer= new Player(width,height,playerPosX,playerPosY,Graphics,Colliders);
		Game._inst.plr=thisPlayer;
		Game._inst.musicSFX.stop();
		tp0 = new Teleporter(new room_StartArea(16, 21, 7, 19, room_StartArea.Graphics, room_StartArea.Colliders, true),new Vector2(6,19), new Vector2(31,7));
		tp1 = new Teleporter(new room_StartArea(16, 21, 7, 19, room_StartArea.Graphics, room_StartArea.Colliders, true),new Vector2(7,19), new Vector2(31,7));
		tp2 = new Teleporter(new room_StartArea(16, 21, 7, 19, room_StartArea.Graphics, room_StartArea.Colliders, true),new Vector2(8,19), new Vector2(31,7));
		tp3 = new Teleporter(new room_StartArea(16, 21, 7, 19, room_StartArea.Graphics, room_StartArea.Colliders, true),new Vector2(9,19), new Vector2(31,7));
		tpR0 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(6,7), new Vector2(8,21));
		tpR1 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(7,7), new Vector2(8,21));
		tpR2 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(8,7), new Vector2(9,21));
		tpR3 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(9,7), new Vector2(9,21));
		flowey = new FloweyStartArea();
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tp0);
		thisPlayer.entities.add(tp1);
		thisPlayer.entities.add(tp2);
		thisPlayer.entities.add(tp3);
		thisPlayer.entities.add(tpR0);
		thisPlayer.entities.add(tpR1);
		thisPlayer.entities.add(tpR2);
		thisPlayer.entities.add(tpR3);
		thisPlayer.playerPosX=(int)pos.x;
		thisPlayer.playerPosY=(int)pos.y;
		thisPlayer.BeginRoom();
	}
	
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			tp0.OnTick(thisPlayer);
			tp1.OnTick(thisPlayer);
			tp2.OnTick(thisPlayer);
			tp3.OnTick(thisPlayer);
			tpR0.OnTick(thisPlayer);
			tpR1.OnTick(thisPlayer);
			tpR2.OnTick(thisPlayer);
			tpR3.OnTick(thisPlayer);
			//System.out.println("Position: "+thisPlayer.playerPosX+", "+thisPlayer.playerPosY);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}

}

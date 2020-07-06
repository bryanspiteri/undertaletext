package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class room_ruins2 extends Room{

	/*if(test==7 && playerPosX==31) {
		System.out.println("NEXT ROOM");
	}*/
	
	public static int width=16;
	public static int height=12;

	public static int playerPosX = 8;
	public static int playerPosY = 18;

	public static Teleporter tp0,tp1;
	public static Teleporter tpR0,tpR1;
	
	Player thisPlayer;    
	
	//MEGA GFX
	//ÔÕÖ×ØÙÚÛÜÝÞßáà
	//âãä   åæç     RUINS WALLS
	//ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßáàâãäåæçèéêëìíîïðñòóôõõöøùúûüýþÿḀḁḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓḔḕḖḗḘḙḚḛḜḜḝḞḟḠ
	//ƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠ  ûüýþḀḁḂḃḄḅḝḞḟḠ
	
	public static String[] Graphics = {
		"¼¼ḟḂḂü¼¼ûḂḂḂḠ¼¼¼", 
		"¼ḟüããä¼¼âãããûḠ¼¼", 
		"¼ḃäãÿä¼¼âãããâûḠ¼",
		"¼ḃäææç¼¼åæææââḅ¼",
		"¼ḃç         åâḅ¼",
		"¼ḃ           åḅ¼",
		"¼ḃ            ḅ¼",
		"¼ḃ            ḅ¼",
		"¼ḃ            ḅ¼",
		"¼¼ï          ð¼¼",
		"¼¼¼¼ï       ð¼¼¼",
		"¼¼¼¼¼¼¼  ¼¼¼¼¼¼¼",
		
	};
	
	//âãä
	
	public static String[] Colliders = {
		"################",
		"################",
		"################",
		"################",
		"###         ####",
		"##           ###",
		"##            ##",
		"##            ##",
		"##            ##",
		"###          ###",
		"#####       ####",
		"#######  #######",
	};
	
	@Override
	public String[] GetGraphics() {
		return Graphics;
	}
	
	@Override
	public String[] GetColliders() {
		return Colliders;
	}

	public room_ruins2(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public void BeginRoom(Vector2 pos){
		thisPlayer= new Player(width,height,playerPosX,playerPosY,Graphics,Colliders);
		Game._inst.plr=thisPlayer;
		tp0 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(8,11),new Vector2(8,6));
		tp1 = new Teleporter(new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true),new Vector2(9,11),new Vector2(9,6));
		tpR0 = new Teleporter(new room_ruins3(16, 21, 7, 19, room_ruins3.Graphics, room_ruins3.Colliders, true),new Vector2(7,3),new Vector2(7,10));
		tpR1 = new Teleporter(new room_ruins3(16, 21, 7, 19, room_ruins3.Graphics, room_ruins3.Colliders, true),new Vector2(8,3),new Vector2(8,10));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tp0);
		thisPlayer.entities.add(tp1);
		thisPlayer.entities.add(tpR0);
		thisPlayer.entities.add(tpR1);
		thisPlayer.playerPosX=(int)pos.x;
		thisPlayer.playerPosY=(int)pos.y;
		thisPlayer.BeginRoom();
	}
	
	
	@Override
	public void OnTick() {
		if(Game._inst._currRoom==this) {
			if(tp0!=null) {
				tp0.OnTick(thisPlayer);
			}
			if(tp1!=null) {
				tp1.OnTick(thisPlayer);
			}
			if(tpR0!=null) {
				tpR0.OnTick(thisPlayer);
			}
			if(tpR1!=null) {
				tpR1.OnTick(thisPlayer);
			}
			/*tp1.OnTick(thisPlayer);
			tpR0.OnTick(thisPlayer);
			tpR1.OnTick(thisPlayer);*/
			thisPlayer.OnTick(Game._inst.delay);
		}
	}
}

package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.SpikeTrap;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.objects.TorMarking;
import github.hyblocker.undertaletext.objects.TorSwitch;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class room_ruins3 extends Room{

	/*if(test==7 && playerPosX==31) {
		System.out.println("NEXT ROOM");
	}*/
	
	public static int width=37;
	public static int height=12;

	public static int playerPosX = 8;
	public static int playerPosY = 18;

	public static Teleporter tp0,tp1;
	public static Teleporter tpR0,tpR1;
	
	//TORIEL'S MARKINGS & SWITCHES
	public static TorMarking marking0,marking1;
	public static TorSwitch switch0,switch1,switch2;
	public static SpikeTrap trap0, trap1;
	
	Player thisPlayer;    

	//MEGA GFX
	//ÔÕÖ×ØÙÚÛÜÝÞßáà
	//âãä   åæç     RUINS WALLS
	//ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßáàâãäåæçèéêëìíîïðñòóôõõöøùúûüýþÿḀḁḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓḔḕḖḗḘḙḚḛḜḜḝḞḟḠ
	//ƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠ  ûüýþḀḁḂḃḄḅḝḞḟḠ
	
	public static String[] Graphics = {
		"¼ḟḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḂḠ¼",
		"¼ḃãããããããããããããããããããããããããããããããããḅ¼",
		"¼ḃãããÿãããããããããããããããããããããããããããããḅ¼",
		"¼ḃæææææææææææææææææææææææææææææææææḀḂ",
		"¼ḃ          ##          ##         âã",
		"¼ḃ          ##          ##         âã",
		"¼ḃ    ê     ##          ##         åæ",
		"¼ḃ                                   ",
		"¼ḃ                                   ",
		"¼ḃ          ##          ##         ýḄ",
		"¼ḃ          ##          ##         ḅ¼",
		"¼ḞḄḄḄþ  ýḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḄḝ¼", 
	};
	
	//âãä
	
	public static String[] Colliders = {
		"#####################################", 
		"#####################################", 
		"#####################################", 
		"#####################################", 
		"##          ##          ##         ##", 
		"##          ##          ##         ##",
		"##    #     ##          ##         ##",
		"##                                   ",
		"##                                   ",
		"##          ##          ##         ##",
		"##          ##          ##         ##", 
		"######  #############################", 
	};
	
	@Override
	public String[] GetGraphics() {
		return Graphics;
	}
	
	@Override
	public String[] GetColliders() {
		return Colliders;
	}

	public room_ruins3(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public void BeginRoom(Vector2 pos){
		thisPlayer= new Player(width,height,playerPosX,playerPosY,Graphics,Colliders);
		Game._inst.plr=thisPlayer;
		boolean hardMode=false;
		if(Game._inst.plrData.charName.toLowerCase().equals("frisk")) {
			hardMode=true;
		}
		//System.out.println(hardMode);
		tp0 = new Teleporter(new room_ruins2(16, 21, 7, 19, room_ruins2.Graphics, room_ruins2.Colliders, true),new Vector2(7,11),new Vector2(7,5));
		tp1 = new Teleporter(new room_ruins2(16, 21, 7, 19, room_ruins2.Graphics, room_ruins2.Colliders, true),new Vector2(8,11),new Vector2(8,5));
		tpR0 = new Teleporter(new room_ruins4(16, 21, 7, 19, room_ruins4.Graphics, room_ruins4.Colliders, true),new Vector2(37,7),new Vector2(2,7));
		tpR1 = new Teleporter(new room_ruins4(16, 21, 7, 19, room_ruins4.Graphics, room_ruins4.Colliders, true),new Vector2(37,8),new Vector2(2,8));
		marking0 = new TorMarking(new Vector2(20,3), !hardMode);
		marking1 = new TorMarking(new Vector2(30,3), !hardMode);
		switch0 = new TorSwitch(new Vector2(21,3), !hardMode, !(Game._inst.plrData.plot>=4), Game._inst.plrData.plot>=4, true, false);
		switch1 = new TorSwitch(new Vector2(31,3), !hardMode, !(Game._inst.plrData.plot>=4), Game._inst.plrData.plot>=4, true, false);
		switch2 = new TorSwitch(new Vector2(32,3), false, false);
		trap0 = new SpikeTrap(new Vector2(36,7),!(Game._inst.plrData.plot>=4));
		trap1 = new SpikeTrap(new Vector2(36,8),!(Game._inst.plrData.plot>=4));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tp0);
		thisPlayer.entities.add(tp1);
		thisPlayer.entities.add(tpR0);
		thisPlayer.entities.add(tpR1);
		thisPlayer.entities.add(marking0);
		thisPlayer.entities.add(marking1);
		thisPlayer.entities.add(switch0);
		thisPlayer.entities.add(switch1);
		thisPlayer.entities.add(switch2);
		thisPlayer.entities.add(trap0);
		thisPlayer.entities.add(trap1);
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
			if(marking0!=null) {
				marking0.OnTick(thisPlayer);
			}
			if(marking1!=null) {
				marking1.OnTick(thisPlayer);
			}
			if(switch0!=null) {
				switch0.OnTick(thisPlayer);
			}
			if(switch1!=null) {
				switch1.OnTick(thisPlayer);
			}
			if(switch2!=null) {
				switch2.OnTick(thisPlayer);
			}
			if(trap0!=null) {
				trap0.OnTick(thisPlayer);
			}
			if(trap1!=null) {
				trap1.OnTick(thisPlayer);
			}
			if(!(Game._inst.plrData.plot>=4)) {
				if(switch0.isActivated()==true && switch1.isActivated()==true) {
					trap0.setState(false);
					trap1.setState(false);
					Audio.PlayOneShot("snd_switchpull_n");
					if(Game._inst.plrData.plot==3) {
						Game._inst.plrData.plot=4;
					}
				}
			}
			if(Game.DEBUG_MODE==true) {
				if(Input.GetKey(KeyCode.F1)) {
					switch0.ActivateSwitch(thisPlayer);
					switch1.ActivateSwitch(thisPlayer);
					trap0.setState(false);
					trap1.setState(false);
					Audio.PlayOneShot("snd_switchpull_n");
					if(Game._inst.plrData.plot==3) {
						Game._inst.plrData.plot=4;
					}
				}
			}
			//System.out.println("plr: "+thisPlayer.playerPosX+","+thisPlayer.playerPosY);
			//System.out.println("trp: "+trap0.getPosition().x+", "+trap0.getPosition().y);
			//System.out.println("Position: "+thisPlayer.playerPosX+", "+thisPlayer.playerPosY);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}
}

package github.hyblocker.undertaletext.rooms;

import java.util.ArrayList;

import github.hyblocker.undertaletext.objects.Entity;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.objects.SaveStructure;
import github.hyblocker.undertaletext.objects.Teleporter;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Vector2;

public class room_ruins1 extends Room {

	/*
	 * if(test==7 && playerPosX==31) { System.out.println("NEXT ROOM"); }
	 */

	public static int width = 16;
	public static int height = 22;

	public static int playerPosX = 8;
	public static int playerPosY = 18;

	public static Teleporter tp0, tp1;
	public static Teleporter tpR0, tpR1;

	public static SaveStructure saver;
	public static String[] SAVERTEXT = {
		"(The shadow of the ruins#looms above, filling you with#determination.)",
		"(HP fully restored)",
	};

	Player thisPlayer;
	
	//MEGA GFX
	//ÔÕÖ×ØÙÚÛÜÝÞßáà
	//âãä   åæç     RUINS WALLS
	//ƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠ
	
	public static String[] Graphics = {
		"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
		"¼ḃ    ḋ  Ḋ    ḅ¼",
		"¼ü    ḋóôḊ    û¼",
		"¼ä  ýþḉḄḄḈýþ  â¼",
		"¼ä  Ḁḁḇ¼¼ḆḀḁ  â¼",
		"¼äõøøøù¼¼úøøøöâ¼",
		"¼äñ          òâ¼",
		"¼ä  ðḍíîíîḎï  â¼", 
		"¼äḏḐḑ¼ḌḌḌḌ¼ḕḖḗâ¼",
		"¼äḒḓḔḜḛḛḛḛḜḘḙḚâ¼",
		"¼äþ          ýâ¼",
		"¼äü          ûâ¼",
		"¼ää          ââ¼",
		"¼ää          ââ¼",
		"¼ää          ââ¼",
		"¼ää          ââ¼",
		"¼ää          ââ¼",
		"¼äç          åâ¼",
		"¼äï          ðâ¼",
		"¼ä¼ï        ð¼â¼",
		"¼¼¼¼¼¼ï  ð¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼  ¼¼¼¼¼¼¼",
		"¼¼¼¼¼¼¼  ¼¼¼¼¼¼¼"
		
	};
	
	public static String[] Colliders = {
		"################",
		"################",
		"################",
		"################",
		"################",
		"################",
		"###          ###",
		"##  ########  ##",
		"##  ########  ##",
		"###   ####   ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"###          ###",
		"####        ####",
		"#######  #######",
		"#######  #######",
		"#######  #######"
	};

	@Override
	public String[] GetGraphics() {
		return Graphics;
	}

	@Override
	public String[] GetColliders() {
		return Colliders;
	}

	public room_ruins1(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider,
			boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}

	@Override
	public void BeginRoom(Vector2 pos) {
		thisPlayer = new Player(width, height, playerPosX, playerPosY, Graphics, Colliders);
		Game._inst.plr = thisPlayer;
		if (Game._inst.musicSFX != null) {
			if (!Game._inst.musicSFX.getLocation().equals(Audio.getFileLocation("mus_ruins"))) {
				try { Game._inst.musicSFX.stop(); } catch (Exception ex) {}
				Game._inst.musicSFX = Audio.MakeSound("mus_ruins");
				Game._inst.musicSFX.loopFromStart();
			} else {
				Game._inst.musicSFX = Audio.MakeSound("mus_ruins");
				Game._inst.musicSFX.loopFromStart();
			}
		}
		tp0 = new Teleporter(
				new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),
				new Vector2(8, 21), new Vector2(7, 8));
		tp1 = new Teleporter(
				new room_StartArea2(16, 21, 7, 19, room_StartArea2.Graphics, room_StartArea2.Colliders, true),
				new Vector2(9, 21), new Vector2(8, 8));
		tpR0 = new Teleporter(new room_ruins2(16, 21, 7, 19, room_ruins2.Graphics, room_ruins2.Colliders, true),
				new Vector2(8, 5), new Vector2(8, 11));
		tpR1 = new Teleporter(new room_ruins2(16, 21, 7, 19, room_ruins2.Graphics, room_ruins2.Colliders, true),
				new Vector2(9, 5), new Vector2(9, 11));
		saver = new SaveStructure(SAVERTEXT, "Ruins entrance", new Vector2(8, 9));
		thisPlayer.entities = new ArrayList<Entity>();
		thisPlayer.entities.add(tp0);
		thisPlayer.entities.add(tp1);
		thisPlayer.entities.add(tpR0);
		thisPlayer.entities.add(tpR1);
		thisPlayer.entities.add(saver);
		thisPlayer.playerPosX = (int) pos.x;
		thisPlayer.playerPosY = (int) pos.y;
		thisPlayer.BeginRoom();
	}

	@Override
	public void OnTick() {
		if (Game._inst._currRoom == this) {
			if (tp0 != null) {
				tp0.OnTick(thisPlayer);
			}
			if (tp1 != null) {
				tp1.OnTick(thisPlayer);
			}
			if (tpR0 != null) {
				tpR0.OnTick(thisPlayer);
			}
			if (tpR1 != null) {
				tpR1.OnTick(thisPlayer);
			}
			if (saver != null) {
				saver.OnTick(thisPlayer);
			}
			/*
			 * tp1.OnTick(thisPlayer); tpR0.OnTick(thisPlayer); tpR1.OnTick(thisPlayer);
			 */
			// System.out.println("Position: "+thisPlayer.playerPosX+",
			// "+thisPlayer.playerPosY);
			thisPlayer.OnTick(Game._inst.delay);
		}
	}

}

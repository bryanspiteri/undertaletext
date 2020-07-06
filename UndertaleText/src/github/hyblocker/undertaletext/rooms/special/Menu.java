package github.hyblocker.undertaletext.rooms.special;

import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.rooms.room_StartArea;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class Menu extends Room {

	boolean LOGO = true;
	
	public String logo = "ƀƁƂƃƄƅƆƇƈƉ";

	float timeElapsed = 0;

	String BLACK = "¼";
	String BLACK_LINE = BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK;
	
	String[] BlackScreen = {
		BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE, BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE,	BLACK_LINE
	};
	
	String[] noSaveTxt = {
		"---Instruction---",
		BLACK_LINE,
		"[ZorENTER]-Confirm",
		"[XorSHIFT]-Cancel",
		"[CorCTRL]-Menu(In-game)",
		"[HoldESC]-Quit",
		"When HP is 0, you lose.",
		BLACK_LINE
	};
	
	String[] currScreen = new String[BlackScreen.length];
	
	public Menu(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, false);
	}
	
	@Override
	public void BeginRoom(Vector2 pos) {
		if (pos.x == Vector2.zero.x && pos.y == Vector2.zero.y) {
			LOGO = false;
		}
		try {
			Game._inst.musicSFX.stop();
		} catch (Exception ex) {
		}
		Game._inst.musicSFX = Audio.MakeSound("mus_menu" + Game.plrData.menuId);
		try {
			Thread.sleep((long) (100));
		} catch (InterruptedException e) {
		}
		Audio.PlayOneShot("mus_intronoise");
	}
	
	boolean menuSFX=false;
	
	@Override
	public void OnTick() {
		if (Game._inst._currRoom == this) {
			System.out.println(Game.plrData.charName);
			currScreen = BlackScreen.clone();
			if (LOGO == true) {
				currScreen[4] = "¼¼¼¼¼¼¼¼¼" + logo +"¼¼¼¼¼¼¼¼¼";
				if (timeElapsed >= 10) {
					currScreen[8] ="¼¼¼¼¼[PRESS¼Z¼TO¼START]¼¼¼¼¼";
				}
				if ((Input.GetKey(KeyCode.Z) && timeElapsed >= 0.2f)
						|| (Input.GetKey(KeyCode.Enter) && timeElapsed >= 0.2f)) {
					Game._inst.musicSFX.loopFromStart();
					LOGO = false;
				}
			} else {
				if (Game.plrData.charName == null || Game.plrData.charName.equals("")) {
					// First time menu
					currScreen[2] = getLine(noSaveTxt[0], 2);
					currScreen[3] = getLine(noSaveTxt[1], 2);
					currScreen[4] = getLine(noSaveTxt[2], 2);
					currScreen[5] = getLine(noSaveTxt[3], 2);
					currScreen[6] = getLine(noSaveTxt[4], 2);
					currScreen[7] = getLine(noSaveTxt[5], 2);
					currScreen[8] = getLine(noSaveTxt[6], 2);
					currScreen[9] = getLine(noSaveTxt[7], 2);
					if (Input.GetKey(KeyCode.Z) || Input.GetKey(KeyCode.Enter)) {
						if (timeElapsed >= 5.5f) {
							Game._inst._currRoom = new Naming(1, 1, 1, 1, room_StartArea.Graphics,
									room_StartArea.Colliders, false);
						}
					}
				} else {
					// Normal menu
				}
			}
			GameRenderer.Draw(currScreen);
			//System.out.println("timeElapsed: " + timeElapsed);
			try {
				timeElapsed += Game.deltaTime;
			} catch (Exception ex) {
			}
		}
	}
	
	public String getLine(String text, int startPos) {
		String wotToReturn = BLACK_LINE;

		final int maxChars = BLACK_LINE.length();

		if (text == BLACK_LINE) {
			return BLACK_LINE;
		} else {
			String tmpTxt = "";
			for (int pos = 0; pos < text.length(); pos++) {
				try {
					String currChar = text.substring(pos, pos + 1);
					// System.out.println(currChar);
					if (currChar.equals(" ")) {
						tmpTxt += BLACK;
					} else {
						tmpTxt += currChar;
					}
				} catch (Exception ex) {
					// ex.printStackTrace();
				}
			}
			wotToReturn = BLACK_LINE.substring(0, startPos) + tmpTxt;
			if (wotToReturn.length() < maxChars) {
				wotToReturn = wotToReturn + BLACK_LINE.substring(wotToReturn.length());
			}
		}

		return wotToReturn;
	}

	public String getLine(String text) {
		return getLine(text, 0);
	}

}

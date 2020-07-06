package github.hyblocker.undertaletext.rooms.special;

import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.rooms.room_StartArea;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class Boot extends Room {

	public static boolean isActiveRoom = false;

	public String BLACK = "¼";

	public float txtSpeed = 0.05f;

	int currScreen = 0;

	boolean displayed = false;

	public static String[] crap = { "", "", "" };

	public Boot(int a, int b, int c, int d, String[] e, String[] f, boolean g) {
		super(28, 21, 6, 4, crap, crap, false);
		Game._inst.musicSFX = Audio.MakeSound("mus_story");
		Game._inst.musicSFX.play();
		isActiveRoom = true;
		/*
		 * try { Thread.sleep(10); Game._inst.musicSFX.loop(); }catch(Exception ex) {
		 * 
		 * }
		 */
	}

	// ĀāĂ
	
	String[] screen0 = {" ăĄ Ččā"," ąĆ ĎďĐ"," ćĈĉđĒē","ĀĊċĀĔĕĂ"};
	String[] screen1 = {"ĜĝĞğĠ ġ","ĢģĤĥĦħĨ","ĩĪ¼īĬĭĮ","įİıĲĳĴĵ"};
	String[] screen2 = {"ĶķĸĹĺĻļ","ĽľĿŀŁłŃ","ńŅņŇňŉŊ","ŋŌōŎŏŐő"};
	String[] screen3 = {"¼¼¼¼¼¼¼","¼¼¼¼¼¼¼","¼¼¼¼¼¼¼","¼¼¼¼¼¼¼"};
	String[] screen4 = {"      ā","  ŒœŔ ā","ŕŖŗŘřŚś","ŜŝŞşŠšŢ"};
	String[] screen5 = {" eg ndā"," eg ndā"," egendā","ĀĀĀĀĀĀĂ"};
	String[] screen6 = {" eg ndā"," eg ndā"," egendā","ĀĀĀĀĀĀĂ"};
	String[] screen7 = {" eg ndā"," eg ndā"," egendā","ĀĀĀĀĀĀĂ"};
	String[] screen8 = {" eg ndā"," eg ndā"," egendā","ĀĀĀĀĀĀĂ"};
	String[] screen9 = {" eg ndā"," eg ndā"," egendā","ĀĀĀĀĀĀĂ"};
	
	String[] text0 = {"Long ago, two races#####j","ruled over Earth:#######j","HUMANS and MONSTERS.####j"};
	String[] text1 = {"One day, war broke######j","out between the two#####j","races.##################j"};
	String[] text2 = {"After a long battle,####j","the humans were#########j","victorious.#############j"};
	String[] text3 = {"They sealed the monstersj","underground with a magicj","spell.##################j"};
	String[] text4 = {"Many years later...#####j","########################j","########################j"};
	String[] text5 = {"#######MT. EBOTT########j","#########201X###########j","########################j"};
	String[] text6 = {"Legends say that those##j","who climb the mountain##j","never return.###########j"};
	String[] NoText ={"########################j","########################j","########################j"};
	
	static int canDetectInput = 0;

	@Override
	public void OnTick() {
		if (displayed == false) {
			Dialog(text0, txtSpeed, screen0);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text1, txtSpeed, screen1);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text2, txtSpeed, screen2);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text3, txtSpeed, screen2);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text4, txtSpeed, screen3);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text5, txtSpeed, screen4);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			Dialog(text6, txtSpeed, screen5);
			if (displayed == true) {
				return;
			}
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
			displayed = true;
			isActiveRoom = false;
			Game._inst.musicSFX.stop();
			Game._inst._currRoom = new room_StartArea(16, 12, 5, 6, room_StartArea.Graphics, room_StartArea.Colliders,
					true);
			Game._inst._currRoom.BeginRoom(new Vector2(room_StartArea.playerPosX, room_StartArea.playerPosY));
		}
	}

	public void Dialog(String[] text, float textSpeed, String[] img) {
		String line1 = "", line2 = "", line3 = "";
		for (int l = 0; l < 3; l++) {
			for (int i = 0; i < (text[l].length()) + 1; i++) {
				if (isActiveRoom) {
					if (Game._inst._currRoom == this) {
						// l=line, i=index
						if (l == 0) {
							line1 = text[0].substring(0, i) + BLACK;
						} else if (l == 1) {
							line1 = text[0];
							line2 = text[1].substring(0, i) + BLACK;
						} else {
							line1 = text[0];
							line2 = text[1];
							line3 = text[2].substring(0, i) + BLACK;
						}
						String[] txt = { line1, line2, line3 };
						DrawScreen(img, txt);
						// If it isn't a #, wait textSpeed
						int x = i - 1;
						if (i - 1 < 0) {
							x = 0;
						} else {
							x = i - 1;
						}
						// System.out.print(text[l].substring(x, i));
						if (text[l].substring(x, i) == "#") {
							continue;
						} else {
							Audio.MakeSound("snd_talkdefault").play();
							try {
								Thread.sleep((long) (textSpeed * 1000));
								canDetectInput++;
							} catch (InterruptedException e) {
							}
						}
						if (Input.GetKey(KeyCode.Z) || Input.GetKey(KeyCode.Enter)) {
							if (canDetectInput > 5) {

								isActiveRoom = false;
								// Game._inst._currRoom = new room_StartArea(16, 12, 5, 6,
								// room_StartArea.Graphics, room_StartArea.Colliders, true);
								// Game._inst._currRoom.BeginRoom(new
								// Vector2(room_StartArea.playerPosX,room_StartArea.playerPosY));
								Game._inst.musicSFX.stop();
								Game._inst._currRoom = new room_StartArea(16, 12, 5, 6, room_StartArea.Graphics,
										room_StartArea.Colliders, true);
								Game._inst._currRoom.BeginRoom(Vector2.zero);
								displayed = true;
								return;
							}
						}
					}
				}
			}
		}
	}
	
	public void DrawScreen(String[] img,String[] txt) {
		String BLACK_LINE=BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK;
		
		//Form a String array containing the stuff we want on screen
		String [] output = {
			BLACK_LINE,
			BLACK_LINE,
			BLACK_LINE,
			BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+img[0]+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+img[1]+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+img[2]+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+img[3]+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK,
			BLACK_LINE,
			BLACK_LINE,
			PrintLine(txt[0]),
			PrintLine(txt[1]),
			PrintLine(txt[2]),
			BLACK_LINE,
			BLACK_LINE,
		};

		// Tell the GameRenderer to render it
		GameRenderer.Draw(output);
	}

	public String PrintLine(String txt) {
		String output;
		output = BLACK + BLACK;
		int len = txt.length();
		for (int i = 0; i < 25; i++) {
			if (i > len) {
				output += BLACK;
			} else if (i < len) {
				int x = i - 1;
				if (x < 0) {
					x = 0;
				}
				String part = txt.substring(x, i);
				if (part.equals(" ") || part.equals("#")) {
					output += BLACK;
				} else {
					output += part;
				}
			} else {
				// Game._windinst.print(BLACK);
			}
		}
		output += BLACK + BLACK;
		return output;
	}
}

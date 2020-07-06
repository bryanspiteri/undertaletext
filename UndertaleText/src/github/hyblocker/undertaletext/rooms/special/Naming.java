package github.hyblocker.undertaletext.rooms.special;

import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.util.Audio;
import github.hyblocker.undertaletext.util.Calc;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;

public class Naming extends Room {

	public Naming(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}

	public String currName = "";
	public boolean canBegin = false;

	public final int maxCharLength = 6;
	public boolean selectedIsVisible = true;
	public float timeElapsed = 0f;

	String BLACK = "¼";
	String BLACK_LINE = BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK+BLACK;
	String DRAW_BLACK_LINE = BLACK_LINE.substring(2, BLACK_LINE.length()-2);
	
	String[] BlackScreen = {
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE,
		BLACK_LINE
	};
	
	String[] Keyboard = {
		BLACK+BLACK+"A¼B¼C¼D¼E¼F¼G"+BLACK+BLACK,
		BLACK+BLACK+"H¼I¼J¼K¼L¼M¼N"+BLACK+BLACK,
		BLACK+BLACK+"O¼P¼Q¼R¼S¼T¼U"+BLACK+BLACK,
		BLACK+BLACK+"X¼W¼X¼Y¼Z¼¼¼¼"+BLACK+BLACK,
		BLACK+BLACK+"a¼b¼c¼d¼e¼f¼g"+BLACK+BLACK,
		BLACK+BLACK+"h¼i¼j¼k¼l¼m¼n"+BLACK+BLACK,
		BLACK+BLACK+"o¼p¼q¼r¼s¼t¼u"+BLACK+BLACK,
		BLACK+BLACK+"v¼w¼x¼y¼z¼¼¼¼"+BLACK+BLACK
	};
	
	String Message = "Is this name correct?";
	
	int currISindex = 0; //current key/option of is this name correct screen
	int currKEYindexX = 0, currKEYindexY = 0; //current key/option of keyboard screen
	
	int currMode = 0; //0=Keyboard Screen    1=is dis correct?     2=spaces
	
	public void Draw(String msg, String name, int currentlySelectedObject) {
		String[] txt = { "", "", "", }; // create a new text[]
		char[] letters = msg.toCharArray(); // for parsing the msg
		int y = 0; // position in txt[]

		for (char letter : letters) {
			if (letter == '#') {
				y++;
				continue;
			} else {
				txt[y] += Character.toString(letter);
			}
		}
		
		//Now that we converted msg into an array (cuz #), draw it and the name
		String[] currentScreen = {
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
			BLACK_LINE,	
		};
		
		String l1="¼¼Yes¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼No¼¼¼¼¼¼";
		String l2="¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼No¼¼¼¼¼¼";
		String l3="¼¼Yes¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼";

		currentScreen[1] = getLine(txt[0], 2);
		currentScreen[2] = getLine(txt[1], 2);
		currentScreen[3] = getLine(txt[2], 2);
		currentScreen[7] = getLine(name, 4);

		String opt = l1;
		switch (currentlySelectedObject) {
		case 0:
			opt = l1;
		case 1:
			opt = l2;
		case 2:
			opt = l3;
		default:
			opt = l1;
		}
		if (canBegin == false) {
			opt = l3;
		}
		currentScreen[currentScreen.length - 1] = opt;
		GameRenderer.Draw(currentScreen);
	}
	
	public void DrawKeyboard() {
		
		String last0 = "¼¼¼Quit¼¼Backspace¼¼¼Done¼¼¼";
		String last1 = "¼¼¼¼¼¼¼¼¼Backspace¼¼¼Done¼¼¼";
		String last2 = "¼¼¼Quit¼¼¼¼¼¼¼¼¼¼¼¼¼¼Done¼¼¼";
		String last3 = "¼¼¼Quit¼¼Backspace¼¼¼¼¼¼¼¼¼¼";

		String[] screen = BlackScreen.clone();
		screen[0] = getLine("Name the fallen human.", 3);
		screen[1] = getLine(currName, 3);
		screen[2] = getLine(Keyboard[0]);
		screen[3] = getLine(Keyboard[1]);
		screen[4] = getLine(Keyboard[2]);
		screen[5] = getLine(Keyboard[3]);
		screen[6] = getLine(Keyboard[4]);
		screen[7] = getLine(Keyboard[5]);
		screen[8] = getLine(Keyboard[6]);
		screen[9] = getLine(Keyboard[7]);
		screen[10] = last0;
		
		int selectedX, selectedY;
		selectedX = (int) (Math.round(currKEYindexX * 2));
		selectedY = (int) (Math.round(currKEYindexY));
		
		// Is the current frame a blink frame (not visible)?
		if (selectedIsVisible == true) {
			// Selected key
			if (selectedY == 8) {
				if (currKEYindexX == 0) {
					screen[10] = last1;
				} else if (currKEYindexX == 1) {
					screen[10] = last2;
				} else if (currKEYindexX == 2) {
					screen[10] = last3;
				}
			} else {
				int actualIndex = 3 + selectedX;
				try {
					String tmp = getLine(Keyboard[selectedY].substring(0, actualIndex - 1) + BLACK
							+ Keyboard[selectedY].substring(actualIndex));
					// System.out.println(tmp);
					screen[selectedY + 2] = tmp;
				} catch (Exception ex) {
					actualIndex -= 2;
					System.out.println("actualIndex: " + (actualIndex - 1));
					String tmp = getLine(Keyboard[selectedY].substring(0, actualIndex - 1) + BLACK
							+ Keyboard[selectedY].substring(actualIndex));
					System.out.println(tmp);
					screen[selectedY + 2] = tmp;
				}
			}
		}

		GameRenderer.Draw(screen);
	}
	
	public String getLine(String text,int startPos) {
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

	public void Begin() {
	}

	@Override
	public void OnTick() {
		// System.out.println(currMode);
		System.out.println("currKEYindex: " + currKEYindexX + ", " + currKEYindexY);
		if (currMode == 0) {
			// keyboard
			if (timeElapsed >= 1f) {
				if (Input.GetKey(KeyCode.Left)) {
					currKEYindexX--;
					Audio.PlayOneShot("snd_mainmenuselect");
					timeElapsed = 0f;
					WrapSelection();
				} else if (Input.GetKey(KeyCode.Right)) {
					currKEYindexX++;
					Audio.PlayOneShot("snd_mainmenuselect");
					timeElapsed = 0f;
					WrapSelection();
				} else if (Input.GetKey(KeyCode.Up)) {
					currKEYindexY--;
					Audio.PlayOneShot("snd_mainmenuselect");
					timeElapsed = 0f;
					WrapSelection();
				} else if (Input.GetKey(KeyCode.Down)) {
					currKEYindexY++;
					Audio.PlayOneShot("snd_mainmenuselect");
					timeElapsed = 0f;
					WrapSelection();
				}
			}
			DrawKeyboard();

		} else if (currMode == 1) {
			// is this correct
			if (canBegin == true) {
				if (Input.GetKey(KeyCode.Left)) {
					currISindex--;
					if (currISindex < 0 || currISindex > 1) {
						currISindex = 0;
					}
					Audio.PlayOneShot("snd_mainmenuselect");
				} else if (Input.GetKey(KeyCode.Right)) {
					currISindex++;
					if (currISindex < 0 || currISindex > 1) {
						currISindex = 0;
					}
					Audio.PlayOneShot("snd_mainmenuselect");
				}
			}
			if (Input.GetKey(KeyCode.Z) || Input.GetKey(KeyCode.Enter)) {
				if (currISindex == 0) {
					currMode = 0;
				} else if (currISindex == 1 && canBegin == true) {
					currMode = 2;
					Game._windinst.clear();
				}
				Audio.PlayOneShot("snd_mainmenuselect");
			} else {
				System.out.println("TRIED TO BEGIN");
				tryBegin(currName, currISindex);
			}
			// tryBegin(currName,currISindex);
		}
		if (timeElapsed % 10 > 5) {
			selectedIsVisible = false;
		} else {
			selectedIsVisible = true;
		}
		timeElapsed += Game.deltaTime;
	}
	
	public void WrapSelection() {
		//Handle the last row first
		if(currKEYindexY == 8) {
			if(currKEYindexX > 2 ){
				currKEYindexX = 0;
				currKEYindexY = 0;
			}
			if(currKEYindexX < 0 ){
				currKEYindexX = 6;
				currKEYindexY = 7;
			}
			currKEYindexX = Calc.Clamp(currKEYindexX, 0, 2);
		} else {
			// Wrap the X selection
			if (currKEYindexX > 6) {
				currKEYindexX = 0;
				currKEYindexY += 1;
			}
			if (currKEYindexX < 0) {
				currKEYindexX = 6;
				currKEYindexY -= 1;
			}
		}
		//Wrap the Y selection
		if(currKEYindexY > 8) {
			currKEYindexY = 0;
		}
		if(currKEYindexY < 0) {
			currKEYindexY = 8;
		}
		//Lock the last row
		if(currKEYindexY == 8) {
			currKEYindexX = Calc.Clamp(currKEYindexX, 0, 2);
		}
	}

	public void tryBegin(String name, int currentINDEX) {
		currName = name;
		name = name.toLowerCase();
		if (name.equals("")) {
			Message = "You must choose a name.";
			canBegin = false;
		} else if (name.equals("aaaaaa")) {
			Message = "Not very creative...?";
			canBegin = true;
		} else if (name.equals("asgore")) {
			Message = "You cannot.";
			canBegin = false;
		} else if (name.equals("toriel")) {
			Message = "I think you should#think of your own#name, my child.";
			canBegin = false;
		} else if (name.equals("sans")) {
			Message = "nope.";
			canBegin = false;
		} else if (name.equals("undyne")) {
			Message = "Get your OWN name!";
			canBegin = false;
		} else if (name.equals("flowey")) {
			Message = "I already CHOSE#that name.";
			canBegin = false;
		} else if (name.equals("chara")) {
			Message = "The true name.";
			canBegin = true;
		} else if (name.equals("alphys")) {
			Message = "D-don't do that.";
			canBegin = false;
		} else if (name.equals("alphy")) {
			Message = "Uh.... OK?";
			canBegin = true;
		} else if (name.equals("papyru")) {
			Message = "I'LL ALLOW IT!!!!";
			canBegin = true;
		} else if (name.equals("napsta") || name.equals("blooky")) {
			Message = "............#(They're powerless to#stop you.)";
			canBegin = true;
		} else if (name.equals("murder") || name.equals("mercy")) {
			Message = "That's a little on-#the-nose, isn't it...?";
			canBegin = true;
		} else if (name.equals("asriel")) {
			Message = "...";
			canBegin = false;
		} else if (name.equals("frisk")) {
			Message = "I was too lazy to#implement hard#mode. Sorry OK?";
			canBegin = true;
		} else if (name.equals("catty")) {
			Message = "Bratty! Bratty!#That's MY name!";
			canBegin = true;
		} else if (name.equals("bratty")) {
			Message = "Like, OK I guess.";
			canBegin = true;
		} else if (name.equals("metta")) {
			Message = "OOOOH!!! ARE YOU#PROMOTING MY BRAND?";
			canBegin = true;
		} else if (name.equals("gerson")) {
			Message = "Wah ha ha! Why not?";
			canBegin = true;
		} else if (name.equals("shyren")) {
			Message = "...?";
			canBegin = true;
		} else if (name.equals("aaron")) {
			Message = "Is this name correct? ; )";
			canBegin = true;
		} else if (name.equals("temmie")) {
			Message = "hOI!";
			canBegin = true;
		} else if (name.equals("woshua")) {
			Message = "Clean name.";
			canBegin = true;
		} else if (name.equals("jerry")) {
			Message = "Jerry.";
			canBegin = true;
		} else if (name.equals("bpants")) {
			Message = "You are really scraping the#bottom of the barrel.";
			canBegin = true;
		} else {
			Message = "Is this name correct?";
			canBegin = true;
		}
		Draw(Message, currName, currentINDEX);
	}
}

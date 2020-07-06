package github.hyblocker.undertaletext.other;

import github.hyblocker.undertaletext.util.Dialog;

public class GameRenderer {

	static final String QUITTING0 = "ƊƋƌ";
	static final String QUITTING1 = "ƊƋƍ";
	static final String QUITTING2 = "ƊƋƎƏ";

	static final String QUITTING = "ƊƋƌƍƎƏ";
	
	//FOR DIALOG
	public final static int width = 26, height = 5;

	public static boolean ShowDialog = false;
	
	public static String[] DialogText= {
		"",
		"",
		"",
	};

	public static String[] prevDraw = new String[12];

	public static void Draw(String[] roomToDraw, boolean reduceScreenTearing) {
		try {
			prevDraw = roomToDraw.clone();
		} catch (Exception ex) {

		}
		if (ShowDialog == true) {
			roomToDraw[roomToDraw.length-height+0]=Dialog.border[0]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[1]+Dialog.border[2];
			roomToDraw[roomToDraw.length-height+1]=""+DialogText[0]+"";
			roomToDraw[roomToDraw.length-height+2]=""+DialogText[1]+"";
			roomToDraw[roomToDraw.length-height+3]=""+DialogText[2]+"";
			roomToDraw[roomToDraw.length-height+4]="";
		}
		if (Game._inst.QuitImageState == 0) {
			// turns out this is simpler, and more efficient and produces the least screen
			// tearing :O
			String output = "";

			for (int i = 0; i < roomToDraw.length; i++) {
				output = output + roomToDraw[i] + "\n";
			}

			Game._windinst.displayArea.setText(output);
		} else {
			String quitTXT = "";
			if (Game._inst.QuitImageState == 1) {
				quitTXT = QUITTING0;
			} else if (Game._inst.QuitImageState == 2) {
				quitTXT = QUITTING1;
			} else if (Game._inst.QuitImageState == 3) {
				quitTXT = QUITTING2;
			}

			String output = "";

			for (int i = 0; i < roomToDraw.length; i++) {
				if (i == 0) {
					output = quitTXT + roomToDraw[i].substring(quitTXT.length(), roomToDraw[i].length()) + "\n";
				} else {
					output = output + roomToDraw[i] + "\n";
				}
			}

			Game._windinst.displayArea.setText(output);
		}
	}

	public static void Draw(String[] roomToDraw) {

		Draw(roomToDraw, true);
	}

	public static void Draw() {
		Draw(prevDraw, true);
	}
}

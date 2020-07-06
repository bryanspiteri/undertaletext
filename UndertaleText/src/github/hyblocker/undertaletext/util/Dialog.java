package github.hyblocker.undertaletext.util;

import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;

public class Dialog {
	
	final static int WIDTH = 26;
	final static int HEIGHT = 5;
	
	static String LINE;
	static String BLACK = "¼";
	
	public static String[] cell = {"(Ring, ring...)"};
	
	public static OggClip defaultSpeak = Audio.MakeSound("snd_talkdefault");
	
	public static String[] border = {
			//ḂḃḄḅ ḡḢḣḤ  υφχψωʹ͵ͺ
			"υ", //TopLeft
			"φ", //TopCenter
			"χ", //TopRight
			"ψ", //MiddleLeft
			BLACK, //MiddleCenter
			"ω", //MiddleRight
			"ʹ", //BottomLeft
			"͵", //BottomCenter
			"ͺ", //BottomRight
	};
	public static String[] empty = {
		"",
		"",
		""
	};
	
	public static void Speak(String[] text) {
		Speak(empty,text,"",0.25f);
	}
	
	public static void Speak(String text) {
		String[] txt = empty.clone();
		try {
			int prevPos=text.indexOf("&");
			txt[0]=text.substring(0, text.indexOf("&"));
			txt[1]=text.substring(prevPos, text.indexOf("&", prevPos));
			txt[2]=text.substring(prevPos, text.indexOf("&", prevPos));
		}catch(Exception ex) {
			System.err.println("FAILED TO SPLIT TEXT INTO STRING ARRAY");
		}
		Speak(empty,txt,"",0.25f);
	}
	
	public static void Speak(String[] face, String[] text, String sound, double textSpeed) {
		LINE="";
		for(int i=0;i<WIDTH-2;i++) {
		LINE+=BLACK;}
		String[] txt=new String[3];
		if(face==empty) {
			
			for(int l=0;l<text.length;l++) {
				for(int i=0;i<text[l].length();i++) {
					if(l==0) {
						txt[0]=text[l].substring(0, i)+LINE.substring(i);
						txt[1]=LINE;
						txt[2]=LINE;
					}else if(l==1) {
						txt[0]=text[0]+LINE.substring(text[0].length());
						txt[1]=text[l].substring(0, i)+LINE.substring(i);
						txt[2]=LINE;
					}else {
						txt[0]=text[0]+LINE.substring(text[0].length());
						txt[1]=text[1]+LINE.substring(text[1].length());
						txt[2]=text[l].substring(0, i)+LINE.substring(i);
					}
					Audio.PlayOneShot(sound);
					try {Thread.sleep((long) (1000/Game.gameTick));}catch(Exception ex) {}
					GameRenderer.DialogText=txt;
					GameRenderer.ShowDialog=true;
				}
			}
		}else {
			for(int l=0;l<text.length;l++) {
				for(int i=0;i<text[l].length();i++) {
					if(l==0) {
						txt[0]=face[0]+text[l].substring(0, i)+LINE.substring(i);
						txt[1]=face[1]+LINE.substring(0,LINE.length()-face[0].length());
						txt[2]=face[2]+LINE.substring(0,LINE.length()-face[0].length());
					}else if(l==1) {
						txt[0]=face[0]+text[0]+LINE.substring(text[0].length(),LINE.length()-face[0].length());
						txt[1]=face[1]+text[l].substring(0, i)+LINE.substring(i,LINE.length()-face[0].length());
						txt[2]=face[2]+LINE.substring(0,LINE.length()-face[0].length());
					}else {
						txt[0]=face[0]+text[0]+LINE.substring(text[0].length(),LINE.length()-face[0].length());
						txt[1]=face[1]+text[1]+LINE.substring(text[1].length(),LINE.length()-face[0].length());
						txt[2]=face[2]+text[l].substring(0, i)+LINE.substring(i,LINE.length()-face[0].length());
					}
					GameRenderer.DialogText=txt;
					GameRenderer.ShowDialog=true;
				}
			}
		}
		GameRenderer.DialogText=txt;
		GameRenderer.ShowDialog=false;
	}
}

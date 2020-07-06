package github.hyblocker.undertaletext.rooms.special;

import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.PlayerVars;
import github.hyblocker.undertaletext.util.Dialog;
import github.hyblocker.undertaletext.util.Vector2;

public class Ending extends Room{
	
	String[] text0 = {
			"heya.",
			"",
			"",
	};
	String[] text1 = {
			"is anyone there...?",
			"",
			"",
	};
	String[] text2 = {
			"well...just calling",
			"to ask.",
			"",
	};
	String[] text3 = {
			"did you ever take",
			"off that gross",
			"bandage...?",
	};
	String[] text4 = {
			"... guess i should",
			"say something else,",
			"too.",
	};
	String[] text5 = {
			"it's been a while,",
			"huh?",
			"",
	};
	String[] text6 = {
			"...",
			"",
			"",
	};
	String[] text7 = {
			"i'll be honest.",
			"",
			"",
	};
	String[] text8 = {
			"i have no idea what",
			"happened for you",
			"to get here.",
	};
	String[] text9 = {
			"this is actually some",
			"sort of error-",
			"handling message.",
	};
	String[] text10 = {
			"so, if you're getting",
			"this ending...",
			"",
	};
	String[] text11 = {
			"tell whoever made the",
			"game, okay?",
			"",
	};
	String[] text12 = {
			"they'll fix it, or",
			"if it's a novel",
			"situation...",
	};
	String[] text13 = {
			"they might even add",
			"another ending to",
			"the game.",
	};
	String[] text14 = {
			"chances are though...",
			"",
			"",
	};
	String[] text15 = {
			"you're just a dirty",
			"hacker, aren't you?",
			"",
	};
	String[] text16 = {
			"yeah, get outta here.",
			"",
			"",
	};
	
	String[] face = {
		"",
		"",
		"",
	};
	
	public Ending(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider, boolean topdown) {
		super(widt, heght, plrPosX, plrPosY, Room, Collider, topdown);
	}
	
	@Override
	public void BeginRoom(Vector2 inPos){
		//ONLY HACKER ENDING SORRY :(
		if(thingsDontMakeSense()) {
			/*Dialog.Speak(Dialog.cell, text, sound, textSpeed);
			Dialog.Speak(face, text, sound, textSpeed);
			Dialog.Speak(face, text, sound, textSpeed);
			Dialog.Speak(face, text, sound, textSpeed);
			Dialog.Speak(face, text, sound, textSpeed);
			Dialog.Speak(face, text, sound, textSpeed);*/
		}
	}
	
	public boolean thingsDontMakeSense() {
		PlayerVars save = Game._inst.plrData;
		boolean flag=false;
		if(save.murderLevel>4 && save.killCount<Game.RUINS_MAX_MONSTER_COUNT) {
			flag=true;
		}
		if(save.plot==2 && save.Pie!=0) {
			flag=true;
		}
		
		if(save.MaxHP==20 && save.killCount>1) {
			flag=true;
		}
		return false;
	}
}

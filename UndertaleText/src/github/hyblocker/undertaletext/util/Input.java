package github.hyblocker.undertaletext.util;

import java.util.ArrayList;
import java.util.List;

import github.hyblocker.undertaletext.other.Game;

public class Input extends Game{
	public static KeyCode[] keys = {
		KeyCode.A,
		KeyCode.B,
		KeyCode.C,
		KeyCode.D,
		KeyCode.E,
		KeyCode.F,
		KeyCode.G,
		KeyCode.H,
		KeyCode.I,
		KeyCode.J,
		KeyCode.K,
		KeyCode.L,
		KeyCode.M,
		KeyCode.N,
		KeyCode.O,
		KeyCode.P,
		KeyCode.Q,
		KeyCode.R,
		KeyCode.S,
		KeyCode.T,
		KeyCode.U,
		KeyCode.V,
		KeyCode.W,
		KeyCode.X,
		KeyCode.Y,
		KeyCode.Z,
		KeyCode.Zero,
		KeyCode.One,
		KeyCode.Two,
		KeyCode.Three,
		KeyCode.Four,
		KeyCode.Five,
		KeyCode.Six,
		KeyCode.Seven,
		KeyCode.Eight,
		KeyCode.Nine,
		KeyCode.Numpad0,
		KeyCode.Numpad1,
		KeyCode.Numpad2,
		KeyCode.Numpad3,
		KeyCode.Numpad4,
		KeyCode.Numpad5,
		KeyCode.Numpad6,
		KeyCode.Numpad7,
		KeyCode.Numpad8,
		KeyCode.Numpad9,
		KeyCode.LeftShift,
		KeyCode.LeftControl,
		KeyCode.RightControl,
		KeyCode.RightShift,
		KeyCode.Space,
		KeyCode.Enter,
		KeyCode.Backspace,
		KeyCode.Escape,
		KeyCode.Peroid,
		KeyCode.Comma,
		KeyCode.ForwardSlash,
		KeyCode.BackSlash,
		KeyCode.SemiColon,
		KeyCode.Apostrophy,
		KeyCode.LeftBracket,
		KeyCode.RightBracket,
		KeyCode.Minus,
		KeyCode.Plus,
		KeyCode.F1,
		KeyCode.F2,
		KeyCode.F3,
		KeyCode.F4,
		KeyCode.F5,
		KeyCode.F6,
		KeyCode.F7,
		KeyCode.F8,
		KeyCode.F9,
		KeyCode.F10,
		KeyCode.F11,
		KeyCode.F12,
		KeyCode.Left,
		KeyCode.Right,
		KeyCode.Up,
		KeyCode.Down,
		KeyCode.Alt,
		KeyCode.NumPeroid,
		KeyCode.NumPlus,
		KeyCode.NumMinus,
		KeyCode.NumSlash,
		KeyCode.NumAsterisk,
		KeyCode.PageUp,
		KeyCode.PageDown,
		KeyCode.NumEnter,
		//KeyCode.Tab
	};
	
	public static List<KeyCode> currKeys = new ArrayList<KeyCode>();
	
	public static boolean GetKey(KeyCode key) {
		//System.out.println("GETKEYCODE");
		if(key==KeyCode.Any) {
			if(currKeys.size()!=0) {
				return true;
			}
		}
		try {
			if(currKeys!=null) {
				for(int i = (currKeys.size() - 1); i >= 0; i--) { 
					KeyCode Ckey = currKeys.get(i);
					if(Ckey == key) {
						return true;
					}
				}
			}	
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return false;
	}
}

package github.hyblocker.undertaletext.util;

import java.util.ArrayList;
import java.util.List;

import github.hyblocker.undertaletext.other.UndertaleBoot;

public class Audio {
	public static List<OggClip> sounds = new ArrayList<OggClip>();
	
	public static String getFileLocation(String filePath) {
		return "/sounds/"+filePath+".ogg";
	}
	
	public static OggClip MakeSound(String filePath) {
		try {
			return new OggClip(UndertaleBoot.class.getResourceAsStream("/sounds/"+filePath+".ogg"),"/sounds/"+filePath+".ogg");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void PlayOneShot(String filePath) {
		try {
			OggClip clip = MakeSound(filePath);
			clip.play();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

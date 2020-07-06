package github.hyblocker.undertaletext.util;

import java.util.Hashtable;
import java.util.Map;

public class AnimationController {
	public Map<String, Animation> animations = new Hashtable<String, Animation>();

	public String CurrentState = "";
	public String NextState = "";
	
	public boolean RequireAnimationComplete = true;

	public void SetState(String id) {
		if (animations.isEmpty() == false && animations.get(id) != null && CurrentState != id) {
			NextState = id;
		}
	}

	public void Tick() {
		if (NextState != "") {
			if(RequireAnimationComplete) {
				if (animations.get(CurrentState).Complete == true) {
					CurrentState = NextState;
					NextState = "";
				} else {
					animations.get(CurrentState).Tick();
				}
			} else {
				CurrentState = NextState;
				NextState = "";
			}
		} else {
			animations.get(CurrentState).Tick();
		}
	}

	public void RegisterAnimation(Animation animation, String id) {
		if (animations.get(id) == null) {
			animations.put(id, animation);
			if (animations.size() == 1) {
				// Default to the first state
				CurrentState = id;
			}
		} else {
			System.err.println("Animation \"" + id + "\" is already defined!");
		}
	}

	public String GetGFX() {
		if (animations.get(CurrentState) == null) {
			return "";
		}
		return animations.get(CurrentState).GetCurrentFrame();
	}
}

package github.hyblocker.undertaletext.util;

import github.hyblocker.undertaletext.other.Game;

public class Animation {

	public String[] frames;
	/*
	 * Basically the FPS
	 */
	public float Samples = 5;
	public int currentIndex = 0;

	/*
	 * Whether or not the animation loops
	 */
	public boolean Loop = true;
	public boolean Complete = false;
	private float time = 0f;

	public Animation(String[] frames, float SampleRate) {
		this.frames = frames;
		this.Samples = SampleRate;
		this.Loop = true;
		currentIndex = 0;
		Complete = false;
	}

	public Animation(String[] frames, float SampleRate, boolean loop) {
		this.frames = frames;
		this.Samples = SampleRate;
		this.Loop = loop;
		currentIndex = 0;
		Complete = false;
	}

	public String GetCurrentFrame() {
		return frames[currentIndex];
	}

	public void Tick() {
		if (time > 1f / Samples) {
			if (!(currentIndex + 1 >= frames.length)) {
				currentIndex++;
				Complete = false;
			} else {
				if (Loop == true) {
					currentIndex = 0;
				}
				Complete = true;
			}
			if (frames.length == 1) {
				Complete = true;
			}
			time = 0;
		}
		time += Game.deltaTime;
	}
}

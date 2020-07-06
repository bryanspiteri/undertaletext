package github.hyblocker.undertaletext.other;

public class UndertaleBoot {
	public static Game instance;
	
	public static void main(String[] args) {
		instance = new Game();
		instance.BeginGame();
	}
}

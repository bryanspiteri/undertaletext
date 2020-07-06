package github.hyblocker.undertaletext.other;

import github.hyblocker.undertaletext.fights.Fight;
import github.hyblocker.undertaletext.objects.Player;
import github.hyblocker.undertaletext.objects.Room;
import github.hyblocker.undertaletext.rooms.room_StartArea;
import github.hyblocker.undertaletext.rooms.room_ruins1;
import github.hyblocker.undertaletext.rooms.room_ruins3;
import github.hyblocker.undertaletext.rooms.special.Boot;
import github.hyblocker.undertaletext.rooms.special.GraphicsTest;
import github.hyblocker.undertaletext.rooms.special.Menu;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.OggClip;
import github.hyblocker.undertaletext.util.SaveManager;
import github.hyblocker.undertaletext.util.TimeUtils;
import github.hyblocker.undertaletext.util.Vector2;

public class Game {

	public static final boolean DEBUG_MODE = true;

	public static Game _inst;
	public static Room _currRoom;
	public static Fight _currFight;
	public static GameRenderer _renderer;

	public static boolean isInFight = false;

	public static Window _windinst;

	public static boolean executeGame = true;

	// Ticks per Second
	public final static float gameTick = 5f;
	public static double deltaTime = 0;

	// Time played
	public static long startTime = System.currentTimeMillis();
	public static long currentTime = startTime;

	// Audio Tracks
	public static OggClip musicSFX;
	public static OggClip soundSFX;

	public static PlayerVars plrData = new PlayerVars();

	// QUIT FRAME
	public static int QuitImageState = 0;

	public static long delay = 0;
	public static Player plr = new Player(2, 2, 1, 1, new String[1], new String[1]);

	public static String[] strArr = { "" };

	// UNDERTALE STUFF
	public static final int RUINS_MAX_MONSTER_COUNT = 20;
	public static int RUINS_CURRENT_MONSTER_COUNT = RUINS_MAX_MONSTER_COUNT;

	public Game() {
		_inst = this;
	}

	public static void BeginGame() {
		Window.MakeWindow(UndertaleBoot.instance);
		SaveManager.loadSave();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (Window.ready == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Disclaimer (because I don't own UNDERTALE)
		_windinst.clear();
		_windinst.println(
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼[DISCLAIMER!]¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼UNDERTALE¼IS¼OWNED¼BY¼TOBY¼\n"+
				"¼FOX.¼I¼DO¼NOT¼OWN¼UNDERTALE\n"+
				"¼THIS¼IS¼JUST¼A¼FAN¼GAME¼¼¼¼\n"+
				"¼THAT¼WORKS¼VIA¼A¼TEXT¼BASED\n"+
				"¼GUI.¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼Press¼[Z]¼to¼continue¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼\n"+
				"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼");
		// Now infintenly wait until the user inputs Z or Enter
		boolean goToBoot = true;
		while (true) {
			if (Input.GetKey(KeyCode.Z) || Input.GetKey(KeyCode.Enter)) {
				break;
			} else if (DEBUG_MODE == true) {
				if (Input.GetKey(KeyCode.F1)) {
					_inst._currRoom = new GraphicsTest(0, 0, 0, 0, strArr, strArr, true);
					_inst._currRoom.BeginRoom(Vector2.zero);
					GameLoop();
					return;
				} else if (Input.GetKey(KeyCode.F2)) {
					_inst._currRoom = new room_ruins3(16, 21, 7, 19, room_ruins3.Graphics, room_ruins3.Colliders, true);
					_inst._currRoom.BeginRoom(new Vector2(7, 10));
					goToBoot = false;
					break;
				} else if (Input.GetKey(KeyCode.F3)) {
					_inst._currRoom = new Menu(16, 12, 5, 6, room_StartArea.Graphics, room_StartArea.Colliders, true);
					_inst._currRoom.BeginRoom(new Vector2(0, 1));
					goToBoot = false;
					break;
				} else if (Input.GetKey(KeyCode.F4)) {
					_inst._currRoom = new room_ruins1(16, 21, 7, 19, room_ruins1.Graphics, room_ruins1.Colliders, true);
					_inst._currRoom.BeginRoom(new Vector2(9, 21));
					goToBoot = false;
					break;
				}
			}
			try {
				Thread.sleep((long) (1 / gameTick * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		SaveManager.loadSave();
		if (goToBoot == true) {
			_inst._currRoom = new Boot(16, 12, 6, 4, strArr, strArr, false);
		}
		_renderer = new GameRenderer();
		executeGame = true;

		GameLoop();
	}

	static float timeEscapeWasHeldDown = 0.0f;

	public static void GameLoop() {
		executeGame = true;
		while (executeGame) {
			long time = System.currentTimeMillis();

			currentTime = time;
			plrData.TimePlayed += TimeUtils.MillisToSeconds(currentTime - startTime);

			// Check if we shall quit
			if (Input.GetKey(KeyCode.Escape)) {
				timeEscapeWasHeldDown += 1 / gameTick;
				if (timeEscapeWasHeldDown < 1f) {
					_inst.QuitImageState = 1;
					QuitImageState = 1;
				} else if (timeEscapeWasHeldDown > 1f && timeEscapeWasHeldDown < 2f) {
					_inst.QuitImageState = 2;
					QuitImageState = 2;
				} else if (timeEscapeWasHeldDown > 2f && timeEscapeWasHeldDown < 3f) {
					_inst.QuitImageState = 3;
					QuitImageState = 3;
				} else if (timeEscapeWasHeldDown > 3f) {
					Quit();
				}
				GameRenderer.Draw();
			} else {
				timeEscapeWasHeldDown = 0f;
				QuitImageState = 0;
				_inst.QuitImageState = 0;
				GameRenderer.Draw();
			}

			/* How long each frame should last - time it took for one frame */
			delay = (long) ((1000 / gameTick) - (System.currentTimeMillis() - time));
			if (delay > 0) {
				try {
					deltaTime = plrData.TimePlayed % 1000;
					deltaTime = deltaTime % 1;
					_inst.OnTick();
					_inst.OnDraw();
					if (_inst.isInFight == false) {
						_currRoom.OnTick();
					} else {
						_currFight.OnTick();
					}
					Thread.sleep(delay);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void Quit() {
		executeGame = false;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void OnTick() {

	}

	public void OnDraw() {

	}
}

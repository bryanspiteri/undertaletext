package github.hyblocker.undertaletext.objects;

import java.util.ArrayList;
import java.util.List;

import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.other.GameRenderer;
import github.hyblocker.undertaletext.util.Animation;
import github.hyblocker.undertaletext.util.AnimationController;
import github.hyblocker.undertaletext.util.Facing;
import github.hyblocker.undertaletext.util.Input;
import github.hyblocker.undertaletext.util.KeyCode;
import github.hyblocker.undertaletext.util.Vector2;

public class Player {
	public static int width = 33;
	public static int height = 13;

	public static final int renderX = 16;
	public static final int renderY = 12;

	public static Vector2 renderPos = Vector2.zero;

	public static int camPosX = 4;
	public static int camPosY = 4;

	public static int playerPosX = 6;
	public static int playerPosY = 6;

	public static String plrColl = "p";
	public static Facing prevDir = Facing.UP;
	public static Facing dir = Facing.UP;

	public Vector2 targetDir = Vector2.zero;

	public boolean canMove = true;
	public static AnimationController animator;

	public static List<Entity> entities = new ArrayList<Entity>();

	long delay = 0;

	public static String[] Graphics = {
			"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
			"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
			"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
			"¼¼ÚÔ       ÕÛ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƞƟ¼¼",
			"¼Ô          Õ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƚƛƜƝ¼",
			"¼            ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼ƔƖ¼Ƙ¼",
			"¼    ÜÝÞ     Û¼¼¼¼¼¼¼¼¼¼¼¼¼¼Ɣƕ¼Ɨ¼",
			"¼    ßàá     ÕÛ¼¼¼¼¼¼¼¼¼¼¼¼¼ƐƑƒƓ¼",
			"¼×                              ¼",
			"¼Ù×                            Ö¼",
			"¼¼Ù×         ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
			"¼¼¼Ù×       ÖØ¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼",
			"¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼¼"

	};

	public static String[] GFXPlr = new String[Graphics.length];

	public static String[] RenderGFX = { "", "", "", "", "", "", "", "", "", "", "", "", };

	public static String[] Colliders = {
			"#################################",
			"#################################",
			"#################################",
			"###         #####################",
			"##           ####################",
			"#            ####################",
			"#            ####################",
			"#             ###################",
			"#                               #",
			"##                              #",
			"###           ###################",
			"####         ####################",
			"#################################" };

	public Player(int widt, int heght, int plrPosX, int plrPosY, String[] Room, String[] Collider) {
		Graphics = Room.clone();
		Colliders = Collider.clone();
		width = widt;
		height = heght;
		playerPosX = plrPosX;
		playerPosY = plrPosY;
		animator = new AnimationController();

		String[] upAnim = {"Ç", "È", "Ç", "É",};
		String[] downAnim = {"À","Á","À","Â"};
		String[] leftAnim = {"Ã", "Ä",};
		String[] rightAnim = {"Å", "Æ",};

		String[] upIdle = {"Ç"};
		String[] downIdle = {"À"};
		String[] leftIdle = {"Ã"};
		String[] rightIdle = {"Å"};
		
		Animation spr_walk_up = new Animation(upAnim, 8);
		Animation spr_walk_down = new Animation(downAnim, 8);
		Animation spr_walk_left = new Animation(leftAnim, 8);
		Animation spr_walk_right = new Animation(rightAnim, 8);

		Animation spr_idle_up = new Animation(upIdle, 1);
		Animation spr_idle_down = new Animation(downIdle, 1);
		Animation spr_idle_left = new Animation(leftIdle, 1);
		Animation spr_idle_right = new Animation(rightIdle, 1);

		animator.RegisterAnimation(spr_idle_up, "spr_idle_up");
		animator.RegisterAnimation(spr_idle_down, "spr_idle_down");
		animator.RegisterAnimation(spr_idle_left, "spr_idle_left");
		animator.RegisterAnimation(spr_idle_right, "spr_idle_right");
		
		animator.RegisterAnimation(spr_walk_up, "spr_walk_up");
		animator.RegisterAnimation(spr_walk_down, "spr_walk_down");
		animator.RegisterAnimation(spr_walk_left, "spr_walk_left");
		animator.RegisterAnimation(spr_walk_right, "spr_walk_right");
		
		animator.RequireAnimationComplete = false;
	}

	public void BeginRoom() {
		Draw(this);
	}

	public static void Draw(Player myPlr) {
		if (Game._inst.plr == myPlr) {
			int boundsMinX = 0, boundsMinY = 0, boundsMaxX = 0, boundsMaxY = 0;
			final int midX = (int) Math.floor(renderX / 2), midY = (int) Math.floor(renderY / 2);

			// Calculate the bounds
			if (playerPosX < midX) {
				boundsMinX = 0;
				boundsMaxX = renderX;
			} else if (playerPosX > width - midX) {
				boundsMinX = width - renderX;
				boundsMaxX = width;
			} else {
				boundsMinX = playerPosX - midX;
				boundsMaxX = playerPosX + midX;
			}

			if (playerPosY < midY) {
				boundsMinY = 0;
				boundsMaxY = renderY;
			} else if (playerPosY > height - midY) {
				boundsMinY = height - renderY;
				boundsMaxY = height;
			} else {
				boundsMinY = playerPosY - midY;
				boundsMaxY = playerPosY + midY;
			}

			// Populate GFXPlr
			GFXPlr = Graphics.clone();

			// Add entities to GFXPlr
			for (Entity entity : entities) {
				String graphic = entity.getSprite();
				if (graphic == "" || graphic == null) {
					// We don't need to draw it, since its null/empty
					continue;
				} else {
					Vector2 entityPos = entity.getPosition();
					GFXPlr[(int) entityPos.y] = GFXPlr[(int) entityPos.y].substring(0, (int) entityPos.x - 1) + graphic
							+ GFXPlr[(int) entityPos.y].substring((int) entityPos.x);
				}
			}

			// Add the player to the mix
			GFXPlr[playerPosY] = GFXPlr[playerPosY].substring(0, playerPosX - 1) + getPlayerGraphic()
					+ GFXPlr[playerPosY].substring(playerPosX);

			// Set RenderGFX
			int rndY = 0;
			for (int i = boundsMinY; i < boundsMaxY; i++) {
				RenderGFX[rndY] = GFXPlr[i].substring(boundsMinX, boundsMaxX);
				rndY++;
			}
			for (int i = 0; i < RenderGFX.length; i++) {
				for (int x = 0; x < RenderGFX[i].toCharArray().length; x++) {
					char ltr = '#';
					try {
						int t = x - 1;
						if (t < 0) {
							t = 0;
						}
						ltr = RenderGFX[i].substring(t, x).toCharArray()[0];
					} catch (Exception ex) {

					}
					if (Character.toString(ltr).equals(getPlayerGraphic())) {
						renderPos = new Vector2(x, i);
					}
				}
			}
			// Render RenderGFX
			GameRenderer.Draw(RenderGFX, true);
		}
	}

	public void OnTick(long delay) {
		if (Game._inst.plr == this) {
			animator.Tick();
			if (canMove == true) {
				this.delay = delay;
				Vector2 dir = new Vector2(0, 0);
				if (Input.GetKey(KeyCode.Up)) {
					dir.y++;
				}
				if (Input.GetKey(KeyCode.Down)) {
					dir.y--;
				}
				if (Input.GetKey(KeyCode.Left)) {
					dir.x++;
				}
				if (Input.GetKey(KeyCode.Right)) {
					dir.x--;
				}
				if (dir.x == 0 && dir.y == 0) {
					switch(this.dir) {
						case UP:
							animator.SetState("spr_idle_up");
							break;
						case DOWN:
							animator.SetState("spr_idle_down");
							break;
						case LEFT:
							animator.SetState("spr_idle_left");
							break;
						case RIGHT:
							animator.SetState("spr_idle_right");
							break;
					}
				} else {
					Move(dir);
				}
			}
			Draw(this);
		}
	}

	private void Move(Vector2 direction) {
		if (Game._inst.plr == this) {
			Vector2 moveDir = new Vector2(0, 0);
			if (direction.x > 0) {
				moveDir.x++;
			}
			if (direction.x < 0) {
				moveDir.x--;
			}
			if (direction.y > 0) {
				moveDir.y++;
			}
			if (direction.y < 0) {
				moveDir.y--;
			}

			// Check Collisions
			int test = 0;
			if (moveDir.y > 0) {
				dir = Facing.UP;
				test = playerPosY - 1;
				boolean move = true;
				if (!Colliders[test].substring(playerPosX - 1, playerPosX).equals("#")) {
					for (Entity entity : entities) {
						if (entity.hasCollider() == true) {
							if (entity.getPosition().x == playerPosX && entity.getPosition().y == test) {
								move = false;
								animator.SetState("spr_idle_up");
							}
						}
					}
					if (move == true) {
						playerPosY = test;
						animator.SetState("spr_walk_up");
					}
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				targetDir.y = test;
				targetDir.x = playerPosX;
			} else if (moveDir.y < 0) {
				dir = Facing.DOWN;
				test = playerPosY + 1;
				boolean move = true;
				if (!Colliders[test].substring(playerPosX - 1, playerPosX).equals("#")) {
					for (Entity entity : entities) {
						if (entity.hasCollider() == true) {
							if (entity.getPosition().x == playerPosX && entity.getPosition().y == test) {
								move = false;
								animator.SetState("spr_idle_down");
							}
						}
					}
					if (move == true) {
						playerPosY = test;
						animator.SetState("spr_walk_down");
					}
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				targetDir.y = test;
				targetDir.x = playerPosX;
			}
			if (moveDir.x > 0) {
				dir = Facing.LEFT;
				test = playerPosX - 1;
				boolean move = true;
				if (test < 0) {
					test = 0;
				}
				if (!Colliders[playerPosY].substring(test - 1, test).equals("#")) {
					for (Entity entity : entities) {
						if (entity.hasCollider() == true) {
							if (entity.getPosition().x == test && entity.getPosition().y == playerPosY) {
								move = false;
								animator.SetState("spr_idle_left");
							}
						}
					}
					if (move == true) {
						playerPosX = test;
						animator.SetState("spr_walk_left");
					}
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				targetDir.x = test;
				targetDir.y = playerPosY;
			} else if (moveDir.x < 0) {
				dir = Facing.RIGHT;
				test = playerPosX + 1;
				if (test < 0) {
					test = 0;
				}
				if (!Colliders[playerPosY].substring(test - 1, test).equals("#")) {
					boolean move = true;
					for (Entity entity : entities) {
						if (entity.hasCollider() == true) {
							if (entity.getPosition().x == test && entity.getPosition().y == playerPosY) {
								move = false;
								animator.SetState("spr_idle_right");
							}
						}
					}
					if (move == true) {
						playerPosX = test;
						animator.SetState("spr_walk_right");
					}
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				targetDir.x = test;
				targetDir.y = playerPosY;
			}
			prevDir = dir;
			for (Entity entity : entities) {
				entity.OnTick(this);
			}
			// VisualizeColliders();
			// Draw();
		}
	}

	private void VisualizeColliders() {
		String[] coll = Colliders.clone();
		coll[playerPosY] = coll[playerPosY].substring(0, playerPosX - 1) + plrColl
				+ coll[playerPosY].substring(playerPosX);

		for (int i = 0; i < coll.length; i++) {
			System.out.println(coll[i]);
		}
	}

	private static String getPlayerGraphic() {
		return animator.GetGFX();
	}
}

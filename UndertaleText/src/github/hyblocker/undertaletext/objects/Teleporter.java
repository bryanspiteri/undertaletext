package github.hyblocker.undertaletext.objects;

import github.hyblocker.undertaletext.other.Game;
import github.hyblocker.undertaletext.util.Vector2;

public class Teleporter extends Entity {
	public Room target;
	public Vector2 positionTotp;
	public Vector2 outPos;

	public Teleporter(Room targ, int inPosX, int inPosY, int outPosX, int outPosY) {
		target = targ;
		positionTotp = new Vector2(inPosX, inPosY);
		outPos = new Vector2(outPosX, outPosY);
	}

	public Teleporter(Room targ, Vector2 inPos, Vector2 outPos) {
		target = targ;
		positionTotp = new Vector2(inPos.x, inPos.y);
		this.outPos = new Vector2(outPos.x, outPos.y);
	}

	@Override
	public boolean hasCollider() {
		return false;
	}

	@Override
	public String getSprite() {
		return "";
	}

	@Override
	public void OnTick(Player thisPlayer) {
		if (thisPlayer.targetDir.equals(positionTotp)) {
			Game._inst._currRoom = target;
			Game._inst._currRoom.BeginRoom(outPos);
		}
	}
}

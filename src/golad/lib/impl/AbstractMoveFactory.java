package golad.lib.impl;

import golad.lib.Move;
import golad.lib.MoveFactory;

/**
 * An abstract implementation of a {@link MoveFactory}.
 * @author Megacrafter127
 */
public abstract class AbstractMoveFactory implements MoveFactory {
	private static final int[] emptyArray=new int[0];
	
	@Override
	public Move createKillMove(int killX, int killY)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		return createTestMove(getBoard(),getPlayerColor(),Move.Type.KILL,killX,killY,emptyArray,emptyArray);
	}

	@Override
	public Move createBirthMove(int x, int y, int[] sx, int[] sy)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		return createTestMove(getBoard(),getPlayerColor(),Move.Type.BIRTH,x,y,sx,sy);
	}
}

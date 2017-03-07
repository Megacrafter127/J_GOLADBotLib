package golad.lib.impl;

import golad.lib.Board;
import golad.lib.CellState;

/**
 * An abstract implementation of an {@link AbstractMoveFactory}, supplying the Board to validate on and the player to validate for from internal variables.
 * @author Megacrafter127
 */
public abstract class DefaultAbstractMoveFactory extends AbstractMoveFactory {
	private final Board board;
	private final CellState player;
	
	/**
	 * Creates a new DefaultAbstractMoveFactory.
	 * @param board The Board to validate on
	 * @param player The Player to validate for
	 * @throws IllegalArgumentException If player.alive is false.
	 * @throws NullPointerException If board is null.
	 */
	public DefaultAbstractMoveFactory(Board board, CellState player) throws IllegalArgumentException,NullPointerException {
		if(board==null) throw new NullPointerException();
		if(!player.alive) throw new IllegalArgumentException();
		this.board = new DelegateBoard(new DefaultBoard(board));
		this.player = player;
	}

	@Override
	public CellState getPlayerColor() {
		return player;
	}

	@Override
	public Board getBoard() {
		return board;
	}

}

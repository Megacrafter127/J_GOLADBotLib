package golad.lib.impl;

import java.util.Set;

import golad.lib.Board;
import golad.lib.CellState;

/**
 * Encapsulates another Board into a readonly state.
 * All declared methods are delegated from the encapsulated Board.
 * 
 * Primarily used to prevent gaining write access to a board by casting it.
 * @author Megacrafter127

 * @see Board
 * @see golad.lib.MutableBoard
 */
public class DelegateBoard implements Board {
	private final Board parent;
	
	/**
	 * Encapsulates the provided Board into a readonly state.
	 * @param parent The Board to encapsulate
	 */
	public DelegateBoard(Board parent) {
		this.parent=parent;
	}

	@Override
	public int getWidth() {
		return parent.getWidth();
	}

	@Override
	public int getHeight() {
		return parent.getHeight();
	}

	@Override
	public CellState getCellStateAt(int x, int y)
			throws IndexOutOfBoundsException {
		return parent.getCellStateAt(x, y);
	}

	@Override
	public int getTotalCellCount(Set<CellState> states)
			throws NullPointerException {
		return parent.getTotalCellCount(states);
	}

	@Override
	public int getAliveNeighborCount(int x, int y)
			throws IndexOutOfBoundsException {
		return parent.getAliveNeighborCount(x, y);
	}

	@Override
	public int getNeighborCellCount(int x, int y, Set<CellState> states)
			throws IndexOutOfBoundsException, NullPointerException {
		return parent.getNeighborCellCount(x, y, states);
	}

	@Override
	public Board iterate() {
		return new DelegateBoard(parent.iterate());
	}
}

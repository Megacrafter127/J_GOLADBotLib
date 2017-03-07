package golad.lib;

/**
 * This interface represents a GOLAD board which's state can be altered.
 * 
 * See {@link Board} for specifics on coordinates.
 * @author Megacrafter127
 * @see Board
 */
public interface MutableBoard extends Board {
	/**
	 * Changes the state of a cell.
	 * @param x The X coordinate of the cell
	 * @param y The Y coordinate of the cell
	 * @param newState The new state the cell should have
	 * @return the previous state of the cell
	 * @throws NullPointerException If newState is <strong>null</strong>.
	 * @throws IndexOutOfBoundsException If the specified coordinates are outside of this board.
	 */
	public CellState setCellStateAt(int x, int y, CellState newState) throws NullPointerException,IndexOutOfBoundsException;
	/**
	 * Copies the CellStates of a specified rectangular area of another {@link Board}.
	 * @param src The Board to copy from
	 * @param srcx The X coordinate of the top-leftmost cell of the area to copy from
	 * @param srcy The Y coordinate of the top-leftmost cell of the area to copy from
	 * @param trgx The X coordinate of the top-leftmost cell of the area to copy into
	 * @param trgy The Y coordinate of the top-leftmost cell of the area to copy into
	 * @param w The width of the copied area
	 * @param h The height of the copied area
	 * @throws NullPointerException If src is <strong>null</strong>.
	 * @throws IndexOutOfBoundsException If any part of the area to copy from or to is outside of the respective {@link Board}.
	 */
	public void copy(Board src, int srcx, int srcy, int trgx, int trgy, int w, int h) throws NullPointerException,IndexOutOfBoundsException;
	
	@Override
	/**
	 * @see Board#iterate()
	 */
	public MutableBoard iterate();
	/**
	 * Overwrites the current state of this board with the state it would have after 1 GOLAD tick.
	 */
	public void iterateSelf();
}

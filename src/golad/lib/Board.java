package golad.lib;

import java.util.Set;

/**
 * This interface represents a GOLAD board which's state can be examined.
 * A GOLAD board is a finite 2 dimensional cartesian grid of cells.
 * In this specification, the top-leftmost cell is at coordinates (0,0), and the bottom-rightmost cell is at coordinates ({@link #getWidth()}-1,{@link #getHeight()}-1)
 * 
 * If the implementing class allows the state of a GOLAD board to be altered, it should implement {@link MutableBoard}.
 * @author Megacrafter127
 * @see MutableBoard
 */
public interface Board {
	/**
	 * Returns the width of this Board.
	 * @return the width of this Board
	 */
	public int getWidth();
	/**
	 * Returns the height of this Board.
	 * @return the height of this Board
	 */
	public int getHeight();
	
	/**
	 * Returns the current state of the cell at the specified coordinates.
	 * @param x The X coordinate of the probed cell
	 * @param y The Y coordinate of the probed cell
	 * @return the state of the probed cell
	 * @throws IndexOutOfBoundsException If the specified coordinates are outside of this board.
	 */
	public CellState getCellStateAt(int x,int y) throws IndexOutOfBoundsException;
	/**
	 * Returns the current number of cells in any of the specified {@link CellState}s.
	 * @param states The set of the specified {@link CellState}s
	 * @return the number of cells
	 * @throws NullPointerException If states is <strong>null</strong>.
	 */
	public int getTotalCellCount(Set<CellState> states) throws NullPointerException;
	
	/**
	 * Returns the current number of alive neighbors of a specified cell.
	 * A cell is considered alive if {@link CellState#alive} is true. 
	 * @param x The X coordinate of the specified cell
	 * @param y The Y coordinate of the specified cell
	 * @return the number of alive neighbors
	 * @throws IndexOutOfBoundsException If the specified coordinates are outside of this board.
	 */
	public int getAliveNeighborCount(int x, int y) throws IndexOutOfBoundsException;
	/**
	 * Returns the current number of neighbors of a specified cell, that are in any of the specified {@link CellState}s.
	 * @param x The X coordinate of the specified cell
	 * @param y The Y coordinate of the specified cell
	 * @param states The set of the specified {@link CellState}s
	 * @return the number of neighbors
	 * @throws IndexOutOfBoundsException If the specified coordinates are outside of this board.
	 * @throws NullPointerException If states is <strong>null</strong>.
	 */
	public int getNeighborCellCount(int x, int y, Set<CellState> states) throws IndexOutOfBoundsException,NullPointerException;
	
	
	/**
	 * Generates the state of this Board after one iteration of GOLAD, and returns a Board containing it.
	 * Preferably the returned Board should be of the same class as this Board.
	 * @return a Board in the state which this board would be in after one iteration of GOLAD.
	 */
	public Board iterate();
}

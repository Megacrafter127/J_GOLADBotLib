package golad.lib.impl;

import java.util.EnumSet;

import golad.lib.Board;
import golad.lib.CellState;
import golad.lib.MutableBoard;

/**
 * A basic implementation of a {@link MutableBoard}.
 * @author Megacrafter127
 * 
 * @see Board
 * @see MutableBoard
 * @see AbstractBoard
 * @see AbstractMutableBoard
 */
public class DefaultBoard extends AbstractMutableBoard {
	/**
	 * The width of this {@link Board}
	 */
	public final int width;
	/**
	 * The height of this {@link Board}
	 */
	public final int height;
	private final CellState[][] grid;
	
	/**
	 * Creates a new board with the specified width and height, initializing each cell with the provided {@link CellState}.
	 * @param w The width of the new board
	 * @param h The height of the new board
	 * @param init The initial CellState of each cell on this board
	 * @throws NullPointerException If init is <strong>null</strong>.
	 * @throws IllegalArgumentException If w or h are less than 0.
	 */
	public DefaultBoard(int w, int h, CellState init) throws NullPointerException,IllegalArgumentException {
		if(w<0 || h<0) throw new IllegalArgumentException("Illegal boardsize.");
		if(init==null) throw new NullPointerException("Initial CellState may not be null.");
		width=w;
		height=h;
		grid=new CellState[width][height];
		for(int x=0;x<width;x++) for(int y=0;y<height;y++) grid[x][y]=init;
	}
	/**
	 * Creates a new board with the specified with and height.
	 * Each cell is initialized as {@link CellState#DEAD}.
	 * @param w The width of the new board
	 * @param h The height of the new board
	 * @throws IllegalArgumentException If w or h are less than 0.
	 */
	public DefaultBoard(int w, int h) throws IllegalArgumentException {
		this(w,h,CellState.DEAD);
	}
	/**
	 * Creates a copy of the provided Board.
	 * @param src The Board to copy.
	 */
	public DefaultBoard(Board src) {
		this(src.getWidth(),src.getHeight());
		copy(src,0,0,0,0,width,height);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public CellState getCellStateAt(int x, int y)
			throws IndexOutOfBoundsException {
		if(x<0 || y<0 || x>=width || y>=height) throw new IndexOutOfBoundsException(String.format("(%d,%d) is not within (0,0) and (%d,%d).", x,y,width,height));
		return grid[x][y];
	}

	@Override
	public CellState setCellStateAt(int x, int y, CellState newState)
			throws NullPointerException, IndexOutOfBoundsException {
		if(newState==null) throw new NullPointerException("CellState may not be null.");
		if(x<0 || y<0 || x>=width || y>=height) throw new IndexOutOfBoundsException(String.format("(%d,%d) is not within (0,0) and (%d,%d).", x,y,width,height));
		CellState old=grid[x][y];
		grid[x][y]=newState;
		return old;
	}

	@Override
	public MutableBoard iterate() {
		MutableBoard ret=new DefaultBoard(this);
		for(int x=0;x<getWidth();x++) for(int y=0;y<getHeight();y++) {
			switch(getAliveNeighborCount(x, y)) {
			case 3:
				ret.setCellStateAt(x, y, getNeighborCellCount(x, y, EnumSet.of(CellState.RED))<2?CellState.BLUE:CellState.RED);
				//$FALL-THROUGH$
			case 2:
				break;
			default:
				ret.setCellStateAt(x, y, CellState.DEAD);
			}
		}
		return ret;
	}
}

package golad.lib.impl;

import java.util.Set;

import golad.lib.Board;
import golad.lib.CellState;

/**
 * A basic abstract implementation of a {@link Board}
 * @author Megacrafter127
 * 
 * @see Board
 * @see AbstractMutableBoard
 * @see DefaultBoard
 */
public abstract class AbstractBoard implements Board {
	@Override
	public int getTotalCellCount(Set<CellState> states)
			throws NullPointerException {
		if(states==null) throw new NullPointerException();
		int counter=0;
		for(int x=0;x<getWidth();x++) for(int y=0;y<getHeight();y++) if(states.contains(getCellStateAt(x,y))) counter++;
		return counter;
	}

	@Override
	public int getAliveNeighborCount(int x, int y)
			throws IndexOutOfBoundsException {
		return getNeighborCellCount(x,y,CellState.ALIVE_STATES);
	}

	@Override
	public int getNeighborCellCount(int x, int y, Set<CellState> states)
			throws IndexOutOfBoundsException, NullPointerException {
		if(states==null) throw new NullPointerException();
		if(x<0 || y<0 || x>=getWidth() || y>=getHeight()) throw new IndexOutOfBoundsException(String.format("(%d,%d) is not within (0,0) and (%d,%d).", x,y,getWidth(),getHeight()));
		int count=0;
		for(int dx=-1;dx<2;dx++) for(int dy=-1;dy<2;dy++) {
			if(dx==0 && dy==0) continue;
			try{
				if(states.contains(getCellStateAt(x+dx,y+dy))) count ++;
			} catch(IndexOutOfBoundsException ex) {}
		}
		return count;
	}
}

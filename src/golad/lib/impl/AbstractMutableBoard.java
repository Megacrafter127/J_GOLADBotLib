package golad.lib.impl;

import golad.lib.Board;
import golad.lib.MutableBoard;

/**
 * A basic abstract implementation of a {@link MutableBoard}.
 * @author Megacrafter127
 * 
 * @see Board
 * @see AbstractBoard
 * @see DefaultBoard
 */
public abstract class AbstractMutableBoard extends AbstractBoard implements MutableBoard {

	@Override
	public void copy(Board src, int srcx, int srcy, int trgx, int trgy, int w,
			int h) throws NullPointerException, IndexOutOfBoundsException {
		if(src==null) throw new NullPointerException();
		if(srcx<0 || srcy<0 || trgx<0 || trgy<0 || w<0 || h<0 || srcx+w>src.getWidth() || srcy+h>src.getHeight() || trgx+w>getWidth() || trgy+h>getHeight()) throw new IndexOutOfBoundsException("Copy-rectangle out of bounds");
		for(int x=0;x<w;x++) for(int y=0;y<h;y++) setCellStateAt(x+trgx,y+trgy,src.getCellStateAt(x+srcx, y+srcy));
	}

	@Override
	public void iterateSelf() {
		copy(iterate(),0,0,0,0,getWidth(),getHeight());
	}
}

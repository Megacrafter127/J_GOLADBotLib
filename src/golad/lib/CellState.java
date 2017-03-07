package golad.lib;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * A CellState denotes the state of a cell on a {@link Board}.
 * @author Megacrafter127
 */
public enum CellState {
	/**
	 * The CellState for a dead cell.
	 */
	DEAD(false),
	/**
	 * The CellState for a red cell.
	 */
	RED(true),
	/**
	 * The CellState for a blue cell.
	 */
	BLUE(true);
	/**
	 * The set of all CellStates which are {@link #alive}.
	 */
	public static final Set<CellState> ALIVE_STATES=Collections.unmodifiableSet(EnumSet.of(RED, BLUE));
	/**
	 * Whether or not this CellState marks a dead cell.
	 */
	public final boolean alive;
	private CellState(boolean alive) {
		this.alive=alive;
	}
}

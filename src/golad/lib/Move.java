package golad.lib;

/**
 * Represents a player's move on a GOLAD {@link Board}.
 * @author Megacrafter127
 * @see Board
 */
public interface Move {
	/**
	 * Denotes the type of a move.
	 * @author Megacrafter127
	 */
	public static enum Type {
		/**
		 * Denotes a move that kills a targeted cell.
		 */
		KILL(0),
		/**
		 * Denotes a move that creates an allied cell at the cost of 2 allied cells elsewhere.
		 */
		BIRTH(2);
		/**
		 * How many allied cells must be sacrificed for a move of this type.
		 */
		public final int sacrifices;
		private Type(int sacrifices) {
			this.sacrifices=sacrifices;
		}
	}
	
	/**
	 * Returns the Type of this move.
	 * @return The Type of this move
	 */
	public Type getMoveType();
	
	/**
	 * Returns the X coordinate of the targeted cell.
	 * @return The X coordinate of the targeted cell
	 * @see #getTargetY()
	 */
	public int getTargetX();
	/**
	 * Returns the Y coordinate of the targeted cell.
	 * @return The Y coordinate of the targeted cell
	 * @see #getTargetX()
	 */
	public int getTargetY();
	
	/**
	 * Returns the X coordinate of the n-th sacrificed cell.
	 * @param index The index of the sacrificed cell within the list of cells sacrificed in this move.
	 * @return The X coordinate of the n-th sacrificed cell
	 * @throws IndexOutOfBoundsException If index is less than 0 or greater or equal to getMoveType().sacrifices .
	 * @see #getSacrificeY(int)
	 * @see #getMoveType()
	 * @see Type#sacrifices
	 */
	public int getSacrificeX(int index) throws IndexOutOfBoundsException;
	/**
	 * Returns the Y coordinate of the n-th sacrificed cell.
	 * @param index The index of the sacrificed cell within the list of cells sacrificed in this move.
	 * @return The Y coordinate of the n-th sacrificed cell
	 * @throws IndexOutOfBoundsException If index is less than 0 or greater or equal to getMoveType().sacrifices .
	 * @see #getSacrificeX(int)
	 * @see #getMoveType()
	 * @see Type#sacrifices
	 */
	public int getSacrificeY(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns the state this board was/is in before this move.
	 * @return The state this board was/is in before this move
	 */
	public Board getOriginalState();
	/**
	 * Returns the state this board is/will be in after this move.
	 * @return The state this board is/will be in after this move
	 */
	public Board getNewState();
}

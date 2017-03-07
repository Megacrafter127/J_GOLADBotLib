package golad.lib;

/**
 * Used by Bots to obtain the current state of the Board, to create Moves and to check them for validity upon creation.
 * @author Megacrafter127
 * @see Move
 * @see Board
 * @see golad.bot.Bot
 */
public interface MoveFactory {
	/**
	 * Returns the CellState representing an alive cell owned by the player that is given this MoveFactory.
	 * Returns <strong>null</strong> if this MoveFactory is given to multiple players or has no associated player.
	 * @return the CellState representing an allied cell
	 */
	public CellState getPlayerColor();
	
	/**
	 * Returns the Board used for the validation of {@link Move}s.
	 * @return the Board used for the validation of Moves
	 */
	public Board getBoard();
	
	/**
	 * Creates a valid Move that kills a cell on the board.
	 * If the created Move would be invalid this method must throw an Exception.
	 * @param killX The X coordinate of the cell to kill
	 * @param killY The Y coordinate of the cell to kill
	 * @return The valid Move that will kill the specified cell
	 * @throws IllegalArgumentException If the cell at the specified coordinates is not alive or killing it violates the rules.
	 * @throws IndexOutOfBoundsException If the specified coordinates lie outside of the {@link Board} the moves are validated against.
	 */
	public Move createKillMove(int killX,int killY) throws IllegalArgumentException,IndexOutOfBoundsException;
	/**
	 * Creates a valid move that creates an allied cell on the board.
	 * If the created Move would be invalid this method must throw an Exception.
	 * @param x The X coordinate of the cell to create
	 * @param y The Y coordinate of the cell to create
	 * @param sx The X coordinates of the allied sacrificed cells
	 * @param sy The Y coordinates of the allied sacrificed cells
	 * @return The valid Move that will create the specified cell
	 * @throws IllegalArgumentException If sx.length or sy.length do not match {@link Move.Type#BIRTH}.sacrifices, or if the cell at the specified coordinates is alive, any of the sacrificed cells are dead or not allied, or the creation of a cell at the specified location using the specified sacrifices violates the rules.
	 * @throws IndexOutOfBoundsException If any of the specified coordinates lie outside of the {@link Board} the moves are validated against.
	 */
	public Move createBirthMove(int x, int y, int[] sx, int[] sy) throws IllegalArgumentException,IndexOutOfBoundsException;
	
	
	/**
	 * Creates a Move validated against the provided Board for the provided player.
	 * @param board The Board to validate the created Move against
	 * @param player The player to validate the created Move for
	 * @param type The Type of Move
	 * @param x The X coordinate of the targeted cell
	 * @param y The Y coordinate of the targeted cell
	 * @param sx The X coordinates of sacrificed allied cells
	 * @param sy The Y coordinates of sacrificed allied cells
	 * @return The created Move
	 * @throws IllegalArgumentException If player is {@link CellState#DEAD}, sx or sy} do not match type.sacrifices or the created Move is invalid.
	 * @throws NullPointerException If board, player, type, sx or sy are <strong>null</strong>.
	 * @throws IndexOutOfBoundsException If any of the supplied coordinates lie outside of board.
	 */
	public Move createTestMove(Board board, CellState player, Move.Type type, int x, int y, int[] sx, int[] sy) throws IllegalArgumentException,NullPointerException,IndexOutOfBoundsException;
}

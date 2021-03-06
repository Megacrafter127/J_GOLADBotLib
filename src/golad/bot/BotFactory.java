package golad.bot;

import golad.lib.CellState;

/**
 * A BotFactory is used to create the instances of {@link Bot} used to represent GOLAD players.
 * @author Megacrafter127
 * @param <E> The type of {@link Bot} generated by this BotFactory.
 * @see Bot
 */
public interface BotFactory<E extends Bot> {
	/**
	 * Returns a Bot ready to participate in the described GOLAD game. Can return a previously returned instance, if said instance is guaranteed to be in a state in which it can play GOLAD.
	 * @param opponentName The name of the opponent Bot
	 * @param opponentVersion The version of the opponent Bot
	 * @param opponentAuthor The author of the opponent Bot
	 * @param boardWidth The width of the Board
	 * @param boardHeight The height of the Board
	 * @param initialCellCount The number of cells each player starts out with
	 * @param ownColor The color of the cells controlled by this player
	 * @return a Bot ready to participate in a GOLAD game.
	 */
	public E createBot(String opponentName, String opponentVersion, String opponentAuthor, int boardWidth, int boardHeight, int initialCellCount, CellState ownColor);
	
	/**
	 * Returns the name of the Bots created by this BotFactory, or "Human" if the created Bots are human interfaces.
	 * @return the name of the Bots
	 */
	public String getName();
	/**
	 * Returns the name of the author of the Bots created by this BotFactory.
	 * @return the name of the author
	 */
	public String getAuthor();
	/**
	 * Returns the version of the Bots created by this BotFactory.
	 * @return the version of the Bots
	 */
	public String getVersion();
}

package golad.bot;

import golad.lib.Board;
import golad.lib.Move;
import golad.lib.MoveFactory;

/**
 * The interface every J_GOLAD bot must implement to meet the specifications of this API. 
 * @author Megacrafter127
 */
public interface Bot {
	/**
	 * Obtains the next move this bot will make in the given situation.
	 * @param factory A MoveFactory to create and validate moves, and to obtain the current state of the {@link Board}.
	 * @param lastOpponentMove The last Move the opponent made, or <strong>null</strong> if this is the first Move of the game
	 * @return The next move of the player controlled by this Bot. If <strong>null</strong> or invalid, the current game is to be instantly lost.
	 */
	public Move getNextMove(MoveFactory factory, Move lastOpponentMove);
	
	/**
	 * Notifies the bot that the game has ended.
	 * @param win <strong>True</strong>, if this Bot has won the game; <strong>false</strong>, if this bot has lost the game; <strong>null</strong>, if the game ended in a draw.
	 */
	public void endGame(Boolean win);
}

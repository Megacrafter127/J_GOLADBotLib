package golad.bot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import golad.lib.Board;
import golad.lib.CellState;
import golad.lib.Move;
import golad.lib.MoveFactory;

/**
 * The interface every J_GOLAD bot must implement to meet the specifications of this API. 
 * @author Megacrafter127
 */
public interface Bot {
	/**
	 * This annotation is used to store basic information of a bot.
	 * If not present, default values are assumed.
	 * @author Megacrafter127
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public static @interface Specs {
		/**
		 * The name of this bot, or "Human" if this is a human interface.
		 * Default value in case of absence is the fully qualified name of the class of the bot.
		 * @return the name of this bot
		 */
		public String name();
		/**
		 * Whether a new instance of this bot is required for each new game.
		 * @return whether a new instance is required for a new game
		 */
		public boolean reinit() default true;
		/**
		 * The version of this bot or human interface.
		 * Default value is "-".
		 * @return the version of this bot
		 */
		public String version() default "-";
		/**
		 * The author of this bot or human interface.
		 * Default value is "Unknown".
		 * @return the author of this bot
		 */
		public String author() default "Unknown";
	}
	/**
	 * This annotation is used to mark the constructor of a Bot that should be used to create an instance of it.
	 * @author Megacrafter127
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.CONSTRUCTOR)
	public static @interface Constructor {
		/**
		 * This enum represents all supported inputs to Bot constructors.
		 * @see Constructor
		 * @author Megacrafter127
		 */
		public static enum Parameter {
			/**
			 * The width of the Board for this game. 
			 */
			BOARD_WIDTH(int.class),
			/**
			 * The height of the Board for this game.
			 */
			BOARD_HEIGHT(int.class),
			/**
			 * The number of cells each player starts out with at the beginning of the game.
			 */
			INIT_CELLS(int.class),
			/**
			 * The color of this player, either {@link CellState#RED} or {@link CellState#BLUE}.
			 */
			COLOR(CellState.class),
			/**
			 * The name of the opponent. "Human" for human opponents.
			 */
			OPPONENT_NAME(String.class),
			/**
			 * The version of the opponent. In case of a human opponent this is the version of the interface.
			 */
			OPPONENT_VERSION(String.class),
			/**
			 * The author of the opponent. In case of a human opponent this is the author of the interface.
			 */
			OPPONENT_AUTHOR(String.class);
			/**
			 * The type of this parameter.
			 */
			public final Class<?> type;
			private Parameter(Class<?> type) {
				this.type=type;
			}
		}
		/**
		 * This array is supposed to represent all parameters of the annotated constructor and is used to gauge which Parameter has which index.
		 * If any element of this array is <strong>null</strong>, it's type does not match the parameter's type, or the length of this array does not match the number of parameters of the annotated constructor, the constructor is treated as if it wasn't annotated.
		 * @return an array as described above
		 */
		public Parameter[] value() default {};
	}
	/**
	 * Obtains the next move this bot will make in the given situation.
	 * @param factory A MoveFactory to create and validate moves, and to obtain the current state of the {@link Board}.
	 * @param lastOpponentMove The last Move the opponent made, or <strong>null</strong> if this is the first Move of the game
	 * @return The next move of the player controlled by this Bot. If <strong>null</strong> or invalid, the current game is to be instantly lost.
	 */
	public Move getNextMove(MoveFactory factory, Move lastOpponentMove);
}

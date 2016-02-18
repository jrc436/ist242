package game.interfaces;

/**
 * An ITextCommand is a slightly more complicated version of IAction. In IAction, you perform actions on inhabitants of
 * the tile, but if you want to do something more complicated, then it won't work. ICommand forces you to take in strings
 * from the console, and translate them into targets. Note that you have to handle all error messages
 * @author jrc
 *
 */
public interface ITextCommand extends ICommand {
	/**
	 * A command a player will use. It represents the actual
	 * @param IPlayer p
	 * The system will pass the player, in case the command makes any changes to the player
	 * @param IMap m
	 * The system will pass the map, in case the command requires any information from the map 
	 * @param args
	 * Any string arguments the player passed with the command
	 * @return
	 * Either the result of the command, or an error message
	 */
	public String command(IPlayer p, IMap m, String... args);
}

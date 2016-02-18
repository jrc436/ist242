package game.interfaces;

/**
 * IAction is a simple way to perform actions on inhabitants of the player's current tile. The simplest actions can
 * be easily implemented with this. Note that you still have to handle error messages for an incorrect number of 
 * arguments or for invalid arguments
 * @author jrc
 */
public interface IAction extends ICommand {
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
	public String performAction(IPlayer p, IMap m, Inhabitant... args);
}

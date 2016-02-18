package game.interfaces;

/**
 * The interface that all command-line level commands must implement. IAction and ITextCommand both extend this, 
 * representing 
 * @author jrc
 *
 */
interface ICommand {
	/**
	 * This is the message that will display if the player calls help
	 * @return
	 * the message that help will display
	 */
	public String helpText();
	/**
	 * The name is the string that the player must type to call this command 
	 * @return
	 * the string that a player would type to call this command
	 */
	public String name();
	
	/**
	 * Any arguments to the command. In general, separate commands should be created for each combination of arguments,
	 * unless there is a compelling reason not to
	 * @return
	 * A descriptive name for each of the arguments
	 */
	public String[] args();
}

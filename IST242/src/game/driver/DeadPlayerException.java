package game.driver;

public class DeadPlayerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1112174579744823827L;
	public DeadPlayerException() {
		super("A dead player can't do that");
	}
}

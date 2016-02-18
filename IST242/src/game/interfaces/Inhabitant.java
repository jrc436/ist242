package game.interfaces;

/**
 * This is a simple interface for the types of things that can appear on a map. There is no reason to extend or implement
 * this to my knowledge
 * @author jrc
 *
 */
public interface Inhabitant extends Named {
	/**
	 * Gives a brief description of the inhabitant. 
	 * @return
	 * A string that describes the inhabitant
	 */
	public String examine();
}

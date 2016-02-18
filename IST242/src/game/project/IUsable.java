package game.project;

/**
 * A usable item is any item that can be used. This could be a consumable (one time use) or reusable item. 
 * @author jrc
 *
 */
public interface IUsable extends IItem {
	public boolean reusable();
}

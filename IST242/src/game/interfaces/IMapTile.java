package game.interfaces;

import game.project.IItem;

import java.util.List;

/**
 * This represents a single tile on the map. The Driver will not call this directly, and instead will call getCurrentTile
 * MapTiles can be generic and reusable (e.g. "a forest") or specific (e.g. "The Forest of Time"). 
 * Either way, the name should follow the convention of "You are in "+tile.getName() making sense.
 * @author jrc
 *
 */
public interface IMapTile extends Named  {
	/**
	 * Returns a list of the items, friendly characters, and monsters in this map tile. Changing this list in a way that
	 * affects future calls should not be possible. 
	 * @return
	 * an immutable list of the items, friendly characters, and monsters
	 */
	public List<Inhabitant> getInhabitants();
	/**
	 * Adds an item to the map tile. There is probably no reason for you to ever call this in your own code, unless
	 * you really want to
	 * @param i
	 * The item to add
	 */
	public void addItem(IItem i);
	
	/**
	 * Gives a description of the surroundings. For instance "A beautiful forest full of fairies"
	 * @return
	 * the description
	 */
	public String description();
}

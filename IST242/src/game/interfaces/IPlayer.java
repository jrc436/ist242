package game.interfaces;

import game.project.IEquippable;
import game.project.IItem;
import game.project.IUsable;

import java.util.List;

/**
 * A player character. This could be extended to include various types of player characters that are slightly different.
 * At this time, different kinds of player characters won't have different actions, but this could be added with 
 * popular demand. It must implement the default constructor. Each class of IPlayer represents a single type of player,
 * where all features of that player are set in the default constructor. 
 * @author jrc
 *
 */
public interface IPlayer extends ICombatant {
	/**
	 * Moves the player in the direction. If there is nowhere to move in that direction, then the player cannot move:
	 * the method should return false and the player should remain in the same location
	 * @param d
	 * The direction to move the player
	 * @return
	 * true if the player can move in that direction, false otherwise
	 */
	public boolean move(Direction d);
	
	/**
	 * This is the current tile the player is on. It should change as the player moves around.
	 * @return
	 * the current tile
	 */
	public IMapTile getCurrentTile();
	
	/**
	 * This gets a tile adjacent to the current tile in the given direction. These should also change as the player moves
	 * around.  Presently, only four directions are supported, but this should in principle extend to more directions.
	 * @param d
	 * The direction from the current tile.
	 * @return
	 * the tile in the direction from the current tile
	 */
	public IMapTile getAdjacentTile(Direction d);
	
	/**
	 * This is only important for the initial placement of the player
	 * @param tile
	 * the starting tile
	 */
	public void placePlayer(IMapTile tile);
	
//	/**
//	 * This determines if the name of the player is set by the player or is a constant value
//	 * @return
//	 * true if the player can decide the name, false if it is constant
//	 */
//	public boolean nameSettable();
//	/**
//	 * Sets the name of the player if its settable. This method should never be called if nameSettable returns false 
//	 * @param name
//	 * The name the player is set to
//	 */
//	public void setName(String name);
}

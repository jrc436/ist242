package game.interfaces;

/**
 * A map represents one level that a player can navigate. Its composed of map tiles. It must implement the default
 * constructor. Each class of IMap represents a single choice of map, where all features of that map are set in that
 * map's default constructor. 
 * @author jrc
 *
 */
public interface IMap {
	/**
	 * This is the first tile the players start on. It could be a random tile in the map, or it could be the same tile
	 * every time 
	 * @return
	 * the first tile that player's will start on when they initially begin the game
	 */
	public IMapTile getStartingTile();
	/**
	 * This should return true if and only if the player has accomplished the objective of the map. If there is no clear
	 * objective, it should return false. You are responsible for keeping track of any and all conditions that would determine
	 * whether or not the map is complete
	 * @return
	 * true if the game (at least on this map!) is over, false otherwise 
	 */
	public boolean mapComplete();
	
	/**
	 * This is the message that displays when the player has completed the map. Can be empty if the map cannot be
	 * completed
	 * @return
	 * the message that will display to the player when mapComplete returns true
	 */
	public String victoryMessage();
	
	/**
	 * This is the message that displays when the player loses for any reason, such as dying in combat
	 * @return
	 * the message that will display to the player when player.dead() returns true
	 */
	public String failureMessage();
}

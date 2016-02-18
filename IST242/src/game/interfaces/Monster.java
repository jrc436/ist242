package game.interfaces;

import game.project.IItem;

import java.util.List;

/**
 * A monster is something that players fight. 
 * @author jrc
 *
 */
public interface Monster extends ICombatant, Inhabitant {
	/**
	 * This boolean represents whether the monster is a boss or not. If it is a boss, its name should refer to a unique
	 * name, rather than something general e.g. "The Red Dragon" would be a boss name, while "red dragon" would be a
	 * non-boss name. This only affects the display for the player.
	 * @return
	 * true if it is a boss, false otherwise
	 */
	public boolean isBoss();
	
	/**
	 * This boolean represents whether the monster will attack the player as soon as it is encountered and whenever the
	 * player does anything, or only when it is being attacked
	 * @return
	 * true if the monster will attack as soon as the player enters its tile, false if it will not
	 */
	public boolean aggressive();
	
	/**
	 * After defeating a monster, that monster might drop certain items
	 * @return
	 */
	public List<IItem> loot();
}

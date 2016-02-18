package game.project;

import game.interfaces.IPlayer;

/**
 * An equippable is a type of item that has permanent effects if equipped, and no effects if unequipped. There are
 * no restrictions on how many items that can be equipped except those you implement
 * @author jrc
 *
 */
public interface IEquippable extends IItem {	
	/**
	 * Returns whether this equippable is currently equipped by the player
	 * @return
	 * true if the item is equipped, false otherwise
	 */
	public boolean equipped();
	/**
	 * In general, this method should be called within player.equip(). It determines what this specific item does.
	 * @param c
	 * The player who is equipping the item
	 */
	void equip(IPlayer c);
	/**
	 * In general, this should be called within player.unequip(). It should undo whatever effects it originally did by
	 * equip. This means that calling equip() + unequip() should leave the player in the exact same state 
	 * @param c
	 * The player who is unequipping the item
	 */
	void unequip(IPlayer c);
}

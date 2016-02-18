package game.project;

import game.interfaces.ICombatant;
import game.interfaces.IPlayer;

import java.util.List;

public interface IAdvancedPlayer extends IPlayer {
	/**
	 * Returns a list of the player's current items. This could start empty, or it could start with any number of items
	 * @return
	 * the list of the player's items
	 */
	public List<IItem> getItems();
	
	/**
	 * Unequips the given item. After equipping and then unequipping, the player's stats should be identical.
	 * @param i
	 * the item the player is unequipping
	 * @return
	 * true if the item was actually equipped, false otherwise
	 */
	public boolean unequip(IEquippable i);
	
	/**
	 * Equips the given item. After equipping and then unequipping, the player's stats should be identical. Note that if
	 * the player has multiple items of the same name, the player's command to call equip will cycle through them. There
	 * is no restriction on what can be equipped except what you impose. 
	 * @param i
	 * the item the player is equipping
	 * @return
	 * False if the item was already equipped, true otherwise
	 */
	public boolean equip(IEquippable i);	
	
	/**
	 * Uses an item on the player
	 * @param i
	 * The item that's being used
	 */
	public void useItem(IUsable i);
	
	/**
	 * Uses the item on the specified target
	 * @param i
	 * The item that's being used
	 * @param target
	 * The target of the item
	 */
	public void useItem(IUsable i, ICombatant target);
	
	/**
	 * Adds an item to the player's inventory, either after defeating a monster or after picking it up from the ground
	 * No limits are imposed to how much the player can carry unless you impose them yourself
	 * @param i
	 * the item to add
	 * @return
	 * if the item was successfully added
	 */
	public boolean pickupItem(IItem i);
}

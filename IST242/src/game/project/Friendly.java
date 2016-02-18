package game.project;

import java.util.List;

import game.interfaces.IFriendlyCharacter;

public abstract class Friendly implements IFriendlyCharacter {
	/**
	 * Some characters might be willing to give the player items, at least under certain conditions
	 * @return
	 * a list of items this character is willing to give the player at this time, or null if none
	 */
	public abstract List<IItem> givePlayerItems();
	
	/**
	 * Some characters might want certain items the player has, at least under certain conditions
	 * @return
	 * a list of items this character is willing to receive from the player at this time, or null if none
	 */
	public abstract List<IItem> receiveItems();
}

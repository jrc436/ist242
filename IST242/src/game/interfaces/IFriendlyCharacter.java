package game.interfaces;

import game.project.IItem;

import java.util.List;

/**
 * IFriendly is the interface for any character you encounter who doesn't want to kill you. They might want to talk to you,
 * give you things, or want things from you. It's up to you to keep track of any and all conditions that might change how they 
 * would want to talk to you. 
 * @author jrc
 *
 */
public interface IFriendlyCharacter extends Named, Inhabitant {
	/**
	 * Some friendly characters might be willing to talk to the player. This can change depending on a variety of things.
	 * @return
	 * What the character says if the player talks to them
	 */
	public String talk();
}

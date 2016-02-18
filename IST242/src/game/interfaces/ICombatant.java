package game.interfaces;

/**
 * Combat is the interface that both IMonster and IPlayer extend. In general, there's no reason you should need to call 
 * this interface. 
 * @author jrc
 *
 */
public interface ICombatant extends Named {
	/**
	 * Perform an attack against an enemy. This attack should have a chance of missing and should do variable damage.
	 * Some part of the chance of missing and damage should be associated with the combatant itself
	 * @param enemyDefense
	 * A single parameter representing the defense of the enemy, it can either increase the chance of missing or 
	 * decrease the damage done
	 * @return
	 * The amount of damage done. If the attack missed, it should return zero. It should never be negative
	 */
	public int attack(int enemyDefense);
	
	/**
	 * Determines who should go first in combat. Higher speed means that the combatant is quicker. 
	 * This can be a fixed value or also include a random component
	 * @return
	 * a value representing speed
	 */
	public int speed();
	
	/**
	 * Gets a single integer value representing defense. This can have a variable component, but should definitely have
	 * a constant feature associated with the character.
	 * @return
	 * the defense of the character
	 */
	public int getDefense();
	
	/**
	 * Gets an integer value for how much health the character has. If a character has 0 HP, it is dead. There should
	 * also be some way to keep track of maximum HP in the event some type of healing is implemented.
	 * @return
	 * the character's current HP
	 */
	public int getCurrentHP();
	
	/**
	 * Reduces the HP of this combatant. HP can never be below zero. If a character's HP is reduced to zero, they die
	 * @param damage
	 * the amount of damage to take
	 * @return
	 * whether the damage killed the player
	 */
	public boolean takeDamage(int damage);
	
	/**
	 * Returns whether the character is dead or not. Once a character is dead, it is dead forever. A dead character 
	 * can perform no other actions 
	 * @return
	 * true if the character is dead, false otherwise
	 */
	public boolean dead();
}

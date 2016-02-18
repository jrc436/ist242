package game.project;

import game.interfaces.ICombatant;
import util.Dice;

public abstract class Combatant implements ICombatant {
	private int attackBonus = 1;
	private int baseDamageBonus = 0;
	private int baseSpeed = 0;
	private Dice damageDice = Dice.D4;
	private int armor = 10;
	private int maxHP = 10;
	private int currentHP = maxHP;
	private boolean dead = false;
	public Combatant(int attackBonus, int baseDamageBonus, int baseSpeed, Dice attackDice, int armor, int maxHP) {
		this.attackBonus = attackBonus;
		this.baseDamageBonus = baseDamageBonus;
		this.baseSpeed = baseSpeed;
		this.damageDice = attackDice;
		this.armor = armor;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
	}
	@Override
	public int attack(int enemyDefense) {
		if (attackBonus + Dice.D20.roll() > enemyDefense) {
			return baseDamageBonus + damageDice.roll();
		}
		return 0;
	}

	@Override
	public int speed() {
		return baseSpeed + Dice.D20.roll();
	}

	@Override
	public int getDefense() {
		return armor;
	}

	@Override
	public int getCurrentHP() {
		return currentHP;
	}

	@Override
	public boolean takeDamage(int damage) {
		currentHP = Math.max(currentHP - damage, 0);
		if (currentHP == 0) {
			dead = true;
		}
		return dead();
	}

	@Override
	public boolean dead() {
		return dead;
	}

}

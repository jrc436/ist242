package game.driver;

import game.interfaces.Direction;
import game.interfaces.ICombatant;
import game.interfaces.IFriendlyCharacter;
import game.interfaces.IMap;
import game.interfaces.IMapTile;
import game.interfaces.IPlayer;
import game.interfaces.Inhabitant;
import game.interfaces.Monster;
import game.project.IItem;

public class Commands {
	private IPlayer p;
	private IMap m;
	public Commands(IPlayer p, IMap m) {
		this.p = p;
		this.m = m;
		p.placePlayer(m.getStartingTile());
	}
	private String helpHelp(String comName, String description, String... args) {
		String retval = comName;
		for (String arg : args) {
			retval += " [" + arg + "]";
		}
		return retval+": "+description;
	}
	public String help() {
		String retval = "";
		retval = app(retval, helpHelp("help", "display this"));
		retval = app(retval, helpHelp("move", "move in direction", "direction"));
		retval = app(retval, helpHelp("attack", "attack target", "target"));
		retval = app(retval, helpHelp("look", "look around the current area"));
		retval = app(retval, helpHelp("look", "look in the given direction", "direction"));
		retval = app(retval, helpHelp("examine", "examine the given inventory item or nearby monster, item, or friendly character", "object"));
		retval = app(retval, helpHelp("loot", "pick up the given item", "item"));
		retval = app(retval, helpHelp("use", "use the given item on the given target", "item", "target"));
		retval = app(retval, helpHelp("equip", "equip the given item", "item"));
		retval = app(retval, helpHelp("use", "use the given item on yourself", "item"));
		retval = app(retval, helpHelp("unequip", "unequip the given item", "item"));
		retval = app(retval, helpHelp("give", "gives the item to the friendly character", "character", "item"));
		retval = app(retval, helpHelp("inventory", "lists the items in your inventory"));
		retval = app(retval, helpHelp("hp", "gives your current hit points"));
		return retval;
	}
	public String hp() {
		return "Current HP: "+p.getCurrentHP();
	}
	public String inventory() {
		String retval = "";
		for (IItem i : p.getItems()) {
			retval = app(retval, i.getName());
		}
		return retval;
	}
	public String give(String character, String item) {
		
	}
	public String equip(String item) {
		
	}
	public String unequip(String item) {
		
	}
	public String use(String item) {
		
	}
	public String look(String item) {
		
	}
	public String loot(String objName) {
		String possibleValue = "Nothing named "+objName+" is lootable";
		for (Inhabitant i : p.getCurrentTile().getInhabitants()) {
			if (i.getName().equals(objName)) {
				if (i instanceof IItem) {
					return app("You have successfully looted "+objName, processAggro());
				}
				else {
					possibleValue = objName+ " is not an item that can be looted";
				}
			}
		}
		return possibleValue;
	}
	public String examine(String objName) {
		for (IItem i : p.getItems()) {
			if (i.getName().equals(objName)) {
				return app(i.examine(), processAggro());
			}
		}
		for (Inhabitant i : p.getCurrentTile().getInhabitants()) {
			if (i.getName().equals(objName)) {
				return app(i.examine(), processAggro());
			}
		}
		return "Nothing named "+objName+" is visible";
	}
	public String look(Direction d) throws DeadPlayerException {
		if (p.dead()) {
			throw new DeadPlayerException();
		}
		if (d == null) {
			return app(lookHere(), processAggro());
		}
		return app(lookSomewhere(p.getAdjacentTile(d)), processAggro());
	}
	private String lookHere() {
		String retval = lookSomewhere(p.getCurrentTile());
		retval = app(retval, "You also see:");
		for (Inhabitant in : p.getCurrentTile().getInhabitants()) {
			if (in instanceof Monster) {
				if (((Monster)in).isBoss()) {
					app(retval, "The boss, "+in.getName());
				}
				else {
					app(retval, "an evil "+in.getName());
				}
			}
			else if (in instanceof IItem) {
				app(retval, "Item: "+in.getName());
			}
			else if (in instanceof IFriendlyCharacter) {
				app(retval, "A friend, "+in.getName());
			}
		}
		return retval;
	}
	private String lookSomewhere(IMapTile mt) {
		return mt.description();
	}
	public String move(Direction d) throws DeadPlayerException {
		if (p.dead()) {
			throw new DeadPlayerException();
		}
		if (d == null) {
			return "Move where? Type help if needed!";
		}
		if (p.move(d)) {
			String retval = p.getName()+" has moved to the "+d.toString();
			return app(retval, processAggro());
		}
		return "You cannot move to the "+d.toString();
	}
	private String processAggro() {
		return processAggro(null);
	}
	private String processAggro(Monster e) {
		String retval = "";
		for (Inhabitant in : p.getCurrentTile().getInhabitants()) {
			if (in instanceof Monster && in != e) {
				Monster m = (Monster) in;
				if (m.aggressive()) {
					retval += singleAttack(m, p, false);
				}
			}
		}
		return retval;
	}
	public String attack(String monsterName) throws DeadPlayerException {
		if (p.dead()) {
			throw new DeadPlayerException();
		}
		String possibleResponse = "There is nothing to attack named that";
		for (Inhabitant i : p.getCurrentTile().getInhabitants()) {
			if (i.getName().equals(monsterName)) {
				if (i instanceof Monster) {
					return attackHelp((Monster)i);
				}
				else {
					possibleResponse = "That is not a valid target of an attack!";
				}
			}
		}
		return possibleResponse;
	}
	
	private String getFormatMonsterName(Monster m) {
		return m.isBoss() ? m.getName() : "the "+m.getName();
	}
	
	private String attackHelp(Monster m) {
		String retval = "";
		if (m.speed() > p.speed()) {
			retval =  app(singleAttack(m, p, false), singleAttack(p, m, true));
		}
		else {
			retval = app(singleAttack(p, m, true), singleAttack(m, p, false));
		}
		return app(retval, processAggro(m));
	}
	private String singleAttack(ICombatant giver, ICombatant receiver, boolean pGiver) {
		if (giver.dead()) {
			return "";
		}
		String gName = pGiver ? giver.getName() : getFormatMonsterName((Monster)receiver);
		String rName = pGiver ? getFormatMonsterName((Monster)receiver) : giver.getName();
		int damage = giver.attack(receiver.getDefense());
		String retval = damageHelp(gName, p.getName(), damage);
		receiver.takeDamage(damage);
		if (damage > receiver.getCurrentHP()) {
			receiver.die();
			retval = app(retval, deathHelp(gName, rName));
			return pGiver ? app(retval, this.m.failureMessage()) : retval;
		}
		return retval;
	}
	private String damageHelp(String actor, String receiver, int damage) {
		return actor + " has dealt "+damage+" damage to "+receiver;
	}
	private String deathHelp(String killer, String dier) {
		return killer + " has slain "+dier;
	}
	private String app(String one, String two) {
		if (two.trim().isEmpty()) {
			return one;
		}
		return one + System.getProperty("line.separator") + two;
	}
}

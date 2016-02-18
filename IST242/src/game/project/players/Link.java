package game.project.players;

import game.interfaces.Direction;
import game.interfaces.ICombatant;
import game.interfaces.IMapTile;
import game.project.Combatant;
import game.project.IAdvancedPlayer;
import game.project.IEquippable;
import game.project.IItem;
import game.project.IUsable;

import java.util.List;

import util.Dice;

public class Link extends Combatant implements IAdvancedPlayer {
	public Link() {
		super(1, 1, 1, Dice.D4, 10, 10);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IItem> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean unequip(IEquippable i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equip(IEquippable i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void useItem(IUsable i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useItem(IUsable i, ICombatant target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean move(Direction d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pickupItem(IItem i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IMapTile getCurrentTile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMapTile getAdjacentTile(Direction d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void placePlayer(IMapTile tile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean nameSettable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

}

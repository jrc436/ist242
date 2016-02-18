package game.project;

import game.interfaces.IPlayer;

public class Sword implements IEquippable {
	private boolean equipped = false;
	@Override
	public String getName() {
		return "Sword";
	}

	@Override
	public String examine() {
		return "It doesn't look very sharp...";
	}

	@Override
	public boolean equipped() {
		return equipped;
	}

	@Override
	public void equip(IPlayer c) {
		equipped = true;
		
	}

	@Override
	public void unequip(IPlayer c) {
		equipped = false;
		
	}

}

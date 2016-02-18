package game.project.commands;

import game.interfaces.IMap;
import game.interfaces.IPlayer;
import game.interfaces.ITextCommand;
import game.project.IAdvancedPlayer;
import game.project.IEquippable;
import game.project.IItem;

import java.util.List;

public class EquipItem implements ITextCommand {
	@Override
	public String command(IPlayer p, IMap m, String... item) {
		if (item.length == 0) {
			return "Equip what?";
		}
		IAdvancedPlayer iap = (IAdvancedPlayer) p;
		String possibleReturn = "No item "+item[0]+" found in "+p.getName()+"'s inventory";
		List<IItem> items = iap.getItems();
		for (IItem i : items) {
			if (i.getName().equals(item[0])) {
				if (i instanceof IEquippable) {
					IEquippable e = (IEquippable)i;
					if (!e.equipped()) {
						e.equip(p);
						return "Equipped "+e.getName();
					}
					else {
						possibleReturn = item[0]+" is already equipped";
					}
				}
				else {
					possibleReturn = item[0]+" is not equippable";
				}
			}
		}
		return possibleReturn;
	}

	@Override
	public String helpText() {
		return "equip the given item";
	}

	@Override
	public String name() {
		return "equip";
	}

	@Override
	public String[] args() {
		return new String[] { "item" };
	}

}

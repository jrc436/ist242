package game.interfaces;

public enum Direction {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	public String toString() {
		switch(this) {
		case EAST:
			return "east";
		case NORTH:
			return "north";
		case SOUTH:
			return "south";
		case WEST:
			return "west";
		default:
			return super.toString();
		}
	}
	public static Direction parseDirection(String d) {
		if (d == null || d.isEmpty()) {
			return null;
		}
		return Direction.valueOf(d);
	}
}

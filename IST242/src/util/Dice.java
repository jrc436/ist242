package util;

import java.util.Random;

public enum Dice {
	D20,
	D6,
	D8,
	D10,
	D12,
	D4;
	public int roll() {
		switch (this) {
		case D10:
			return DiceLogic.rollD10();
		case D12:
			return DiceLogic.rollD12();
		case D20:
			return DiceLogic.rollD20();
		case D4:
			return DiceLogic.rollD4();
		case D6:
			return DiceLogic.rollD6();
		case D8:
			return DiceLogic.rollD8();
		default:
			throw new UnsupportedOperationException();
		}
	}
}
class DiceLogic {
//	private static final int seed = 1;
	private static final Random r = new Random();
//	public DiceLogic() {
//		this(false);
//	}
//	public DiceLogic(int seed) {
//		r = new Random(seed);
//	}
//	public DiceLogic(boolean randomSeed) {
//		r = randomSeed ? new Random() : new Random(seed);
//	}
	public static int rollD20() {
		return r.nextInt(20)+1;
	}
	public static int rollD6() {
		return r.nextInt(6) + 1;
	}
	public static int rollD8() {
		return r.nextInt(8) + 1;
	}
	public static int rollD10() {
		return r.nextInt(10) + 1;
	}
	public static int rollD12() {
		return r.nextInt(12) + 1;
	}
	public static int rollD4() {
		return r.nextInt(4) + 1;
	}
}

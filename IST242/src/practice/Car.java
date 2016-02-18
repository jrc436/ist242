package practice;

public class Car {
	public static void main(String[] args) {
		int initialYear = 2016;
		int finalYear = 2024;
		double initialCost = 55000;
		double deprecation = 0.666;
		System.out.println(costAfterYears(finalYear - initialYear, initialCost, deprecation));
		System.out.println(loopCost(initialYear, finalYear, initialCost, deprecation));
	}
	//here is how most students approached the problem, you use a loop to continually update its cost
	//here I use a simple int cast instead of rounding, so it can potentially estimate 1 lower than the other method
	public static int loopCost(int firstYear, int finalYear, double initialCost, double deprecation) {
		double returnVal = initialCost;
		for (int year = firstYear; year < finalYear; year++) {
			returnVal = returnVal * 0.666;
		}
		return (int) returnVal;
	}
	
	//as we know, a multiplying over and over again is the same thing as taking the exponent. In this example, I do
	//just that using the Math library. I think use "Round" to get a better approximation of the dollar value
	public static int costAfterYears(int years, double initialCost, double deprecation) {
		return (int) Math.round(initialCost * Math.pow(deprecation, (double)years));
	}
}

package practice;

public class Fibonacci {
	public static void main(String[] args) {
		fibPrintLoop(10000);
		System.out.println();
		fibPrintRec(10000);
		System.out.println();
		fibWhileLoop(10000);
	}
	//this is what most students seemed to be working toward
	public static void fibWhileLoop(int maxValue) {
		int first = 0;
		int second = 1;
		while (first < maxValue) {		
			System.out.print(first+",");
			int tmp = second;
			second += first;
			first = tmp;
		} 
	}

	//I promised you could do it with a for loop, but it requires a slightly different way of thinking about the problem
	//here, the n represents which fibonacci number you're trying to get
	public static int loopFib(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		int first = 0;
		int second = 1;
		for (int i = 0; i < n; i++) {
			int tmp = second;
			second += first;
			first = tmp;
		}
		return first;
	}
	//here's a way to compute the nth fibonacci value without using a loop: you just use a recursive method call
	public static int recFib(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return recFib(n-1) + recFib(n-2);
	} 
	
	//these two methods are identical, I just didn't want to introduce passing a method as an argument here.
	//they print based on what the max value is
	public static void fibPrintLoop(int maxFib) {
		int curFib = 0;
		int fibNumber = 1;
		while (curFib < maxFib) {
			System.out.print(curFib+",");
			curFib = loopFib(fibNumber);
			fibNumber++;		
		}
	}
	public static void fibPrintRec(int maxFib) {
		int curFib = 0;
		int fibNumber = 1;
		while (curFib < maxFib) {
			System.out.print(curFib+",");
			curFib = recFib(fibNumber);
			fibNumber++;
		}
	}
}

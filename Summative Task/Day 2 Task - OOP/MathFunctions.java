public class MathFunctions {

	private static MathFunctions instance;

	private MathFunctions() {
	}

	public static MathFunctions getInstance() {
		if (instance == null) {
			instance = new MathFunctions();
		}
		return instance;
	}

	/*
	 * Square Root
	 */
	public String squareRoot(double number) {
		double t = 0;
		double squareRoot = number / 2;
		while ((t - squareRoot) != 0) {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		}
		return String.valueOf(squareRoot);
	}

	/*
	 * 
	 * Factorial
	 */
	public String getFactorial(double number) {
		int val = 1;
		for (int i = 1; i <= number; i++)
			val *= i;
		return String.valueOf(val);
	}

	/*
	 * Exponents
	 */
	public String getExponent(double number, double exp) {
		double b = exp;
		int e = 2;
		double a = 0;
		e++;
		a = number * number;
		while (b >= e) {
			a = a * number;
			e++;
		}
		return String.valueOf(a);
	}
}

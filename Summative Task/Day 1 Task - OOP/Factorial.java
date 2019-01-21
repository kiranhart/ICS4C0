
public class Factorial {

	//Store the number passed by constructor for later use
	private int number;
	
	//The only constructor will take in a int value
	public Factorial(int number) {
		//Assign the number variable to the number passed through the constructor
		this.number = number;
	}
	
	//Calculate the factorial of the number using a simple algorithm
	public int getResult() {
		int val = 1;
		for (int i = 1; i <= number; i++) {
			val *= i;
		}
		return val;
	}
	
	//Get the number
	public int getNumber() {
		return this.number;
	}
	
	//Set the number
	public void setNumber(int number) {
		this.number = number;
	}
}

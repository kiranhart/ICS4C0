import java.util.Scanner;

public class Core {

	//Create an instance of the Factorial class
	private Factorial factorial;
	
	//Get the scanner
	private Scanner scanner;
	
	public Core() {
		//Initialize the scanner;
		scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the factorial program!");
		while(true) {
			int val = 0;
			System.out.println("Enter a whole number: ");
			
			//Assign the input the the val variable
			val = scanner.nextInt();
			
			//Perform the calculation
			factorial = new Factorial(val);
			
			//Print the result
			System.out.println(val + " Factorial is: " + factorial.getResult());
		}
	}
	
	public static void main(String[] args) {
		new Core();
	}
}

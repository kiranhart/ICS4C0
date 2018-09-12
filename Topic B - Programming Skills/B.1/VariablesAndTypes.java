package com.kiranhart.ics4c0.b1;

public class VariablesAndTypes {

	/*
	 * Main Method, called when you click run
	 */
	public static void main(String[] args) {

		/*
		 * Byte - (number, 1 byte)
		 * Short - (number, 2 bytes)
		 * Int - (number, 4 bytes)
		 * Long - (number, 8 bytes)
		 * Float - (decimal number, 4 bytes)
		 * Double - (decimal, 8 bytes)
		 * Char - (a character, 2 bytes)
		 * Boolean -  (true or false, 1 byte)
		 */
		
		/*
		 * Level 2:
		 * 
		 * 3. You would usually use an int when dealing with whole numbers
		 * 
		 * 4. When the range of an int is too small for your use.
		 * 
		 * 5. Float is a floating point number meaning it's a decimal like 0.5 while an int is a whole number like 5
		 * 
		 * 6. A float is between -1 and 1 (ex. 0.12f) and a double is larger so 5.231D
		 * 
		 * 7. When you want to deal with single characters like a # for example to compare it with other characters, strings are like sentences.
		 * 
		 * 8. You use a + or if you want to be complicated you a StringBuilder
		 * 
		 * 9. It's used to determine if something is true or false, ex. if(statement is true) { run some code} else { run other code }
		 * 
		 * 10. Nothing, it means true or false, 1, 0. Only difference is the syntax formatting if im correct.
		 * 
		 */
		
		//Question 11
		
		//EZ Way
		System.out.println("H3110 w0r1d 2.0 true");
		System.out.println(" ");
		
		//Long Way
		int helloConcat = 3110;
		double theDouble = 2.0D;
		boolean theBoolean = true;
		
		System.out.println("H" + helloConcat + " w" + 0 + "r" + 1 + "d " + theDouble + " " + theBoolean);
		
		//I didn't see any solution, although I'm going to assume it means that it's just asking you to concatenate different variables.
	}
}

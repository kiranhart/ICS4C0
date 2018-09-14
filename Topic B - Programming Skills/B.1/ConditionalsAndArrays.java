package com.kiranhart.ics4c0.b1;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ConditionalsAndArrays {

	private void booleanOperators() {

		// > < <= >= != ==
		if (10 > 5) {
			System.out.println("10 Is bigger than 5!");
		} else {
			System.out.println("That is not true");
		}

		if (10 < 5) {
			System.out.println("10 is not smaller than 5!");
		} else {
			System.out.println("That is not true");
		}

		if (5 <= 10) {
			System.out.println("5 is less or equal to 10");
		} else {
			System.out.println("That is not true");
		}

		if (5 >= 10) {
			System.out.println("5 is not bigger or equal to 10");
		} else {
			System.out.println("That is true");
		}

		if (1515 != 1414) {
			System.out.println("Correct those numbers are not the same!");
		} else {
			System.out.println("Those numbers are the same");
		}

		if (true == false) {
			System.out.println("True equals false?");
		} else {
			System.out.println("Correct, true cannot equal false");
		}
	}

	private void andOr() {
		/*
		 *  The || means that one of x amount of statements in a if statement or whatever
		 *  you are using must be true for the code to run, else do something else
		 *  so like if 5 == 1 || (or) 5 > 1, one of those are true, so it runs 
		 */
		
		if (100 > 101 || 600 != 500) {
			System.out.println("One of those statements were correct!");
		} else {
			System.out.println("Neither of those statements were correct!");
		}

		/*
		 * The && Operator is used when you need to make sure one or more statements are
		 * true before the code runs, if one is false, run the else statement if present. 
		 */
		
		if (15124 < 15125 && 1 != 0) {
			System.out.println("Both these statements were true!");
		} else {
			System.out.println("One or more of those statements were not true!");
		}
	
		/*
		 * The ? is probably the coolest operator in my opinion.
		 * 
		 * example: 
		 * 	
		 * boolean canRegister = (userAge >= 13) ? true : false;
		 * this assigns a value depending on a statement, first method after ? is what 
		 * occurs if the statement is true, after the : if the statement is false.
		 */
		
		/*
		 * ====== Number 8 ========
		 * 
		 * You can't compare strings using == you must use .equals or .equalsIgnoreCase
		 * 
		 * ====== Number 9 ========
		 * 
		 * Because you're comparing the two identical strings using the correct method (.equals)
		 */
	}

	private void arrays() {
		//Question #11
		int[] intArray = new int[4];
		for (int i = 0; i < intArray.length; i++) intArray[i] = ThreadLocalRandom.current().nextInt(101);
		System.out.println("Array Size: " + intArray.length);
		System.out.println("Last Element: " + intArray[intArray.length - 1]);
		System.out.println("---- Array Elements ----");
		for (int i = 0; i < intArray.length; i++) System.out.println(intArray[i]);;
		
		
		//Question #12
		String[] stringArray = new String[4];
		for (int i = 0; i < stringArray.length; i++) stringArray[i] = UUID.randomUUID().toString();
		System.out.println("Array Size: " + stringArray.length);
		System.out.println("Last Element: " + stringArray[stringArray.length - 1]);
		System.out.println("---- Array Elements ----");
		for (int i = 0; i < stringArray.length; i++) System.out.println(stringArray[i]);;
	}
	
	private ConditionalsAndArrays() {
		System.out.println("============================");
		booleanOperators();
		System.out.println("============================");
		andOr();
		System.out.println("============================");
		arrays();
		System.out.println("============================");
	}

	public static void main(String[] args) {
		new ConditionalsAndArrays();
	}
}

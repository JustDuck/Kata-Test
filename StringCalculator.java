package kataTestR1.java;

//Reference1:  https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/
//I also used a little of their code in parts

//Reference2: http://osherove.com/tdd-kata-1/
//https://github.com/vfarcic/TechnologyConversations/blob/master/src/test/java/com/wordpress/technologyconversations/tddbestpractices/StringCalculatorTest.java

/**
 * Per your request, I attempted via the link you sent to fullfill the 
 * requirements for the Kata examples using a StringCalculator java class
 * In so doing, I started with the first link, and mostly used the code in
 * that resource.  I chose, mostly to comment out the previous code 
 * supplied and added in the new.
 * 
 * At the same time, after creating a StringCalculatorTest java 
 * class file, I added in the code for the test cases.  These were 
 * also provided.
 * 
 * The requirements are listed separately with in the code.
 * In total there are eleven.
 * 
 * For another time, unlike the git hub code that had things
 * arranged their way, it makes sense to me to do otherwise.
 * 
 * The environment employed is:  eclipse luna, jdk 8, junit-4.6
 * Authors are osherove and technologyconversations, and maybe one other source
 * 
 */
import java.util.ArrayList;
import java.util.List;

// This is class is the original with commented out lines that I removed on 07/01/17

// The project structure now is separated into two packages:

//a.  kataTestR1.java; = contains 9 StringCalculatorX class files 

//b. kataTestR1.test; = contains 9 StringCalculatorXTest class files with 2
// for the JunitTestSuite.


public class StringCalculator {

	static int count = 0;

	public void myMethod() {
		count++;
	}

	public static void main(String[] args) {

	}

	// Number 6 
	
	public static int add(final String numbers) {
		String delimiter = ",|n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers
					.substring(numbers.indexOf("n") + 1);
		}
		System.out.println("numbersWithoutDelimiter " + numbersWithoutDelimiter
				+ " delim" + delimiter);
		
		System.out.println("\n");
		return add(numbersWithoutDelimiter, delimiter);
	}

	// Number 8


	private static int add(final String numbers, final String delimiter) {
		int returnValue = 0;
		count++;
		String[] numbersArray = numbers.split(delimiter);
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number.trim());
				if (numberInt < 0) {
					negativeNumbers.add(numberInt);
				} else if (numberInt <= 1000) {
					returnValue += numberInt;
				}
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: "
					+ negativeNumbers.toString());
		}

		System.out.println("Count at the end is " + count);
		System.out.println("Your return Value is " + returnValue);
		System.out.println("\n");
		return returnValue;
	}

	public static int addA(final String numbers) {

		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers
					.substring(numbers.indexOf("\n") + 1);
		}
		System.out.println("numbersWithoutDelimiter " + numbersWithoutDelimiter
				+ " delim" + delimiter);
		
		System.out.println("\n");
		return add(numbersWithoutDelimiter, delimiter);
	}

}
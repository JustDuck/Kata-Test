//Reference:  https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/
//I also used a little of their code in parts

//Reference: http://osherove.com/tdd-kata-1/
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

public class StringCalculator {

	static int count = 0;

	public void myMethod() {
		count++;
	}

	public static void main(String[] args) {

		StringCalculator sc = new StringCalculator();

		System.out.println("Got a string calculator object.");

	}

	/*
	 * public static final void add(final String numbers) { String[]
	 * numbersArray = numbers.split(","); if (numbersArray.length > 2) { throw
	 * new
	 * RuntimeException("Up to 2 numbers separated by comma (,) are allowed"); }
	 * else { for (String number : numbersArray) { Integer.parseInt(number); //
	 * If it is not a number, parseInt will throw an exception } } }
	 */
	/*
	 * public static final int add(final String numbers) { // Changed void to
	 * int String[] numbersArray = numbers.split(","); if (numbersArray.length >
	 * 2) { throw new
	 * RuntimeException("Up to 2 numbers separated by comma (,) are allowed"); }
	 * else { for (String number : numbersArray) { if (!number.isEmpty()) {
	 * Integer.parseInt(number); } } } return 0; // Added return }
	 */
	/*
	 * public static int add(final String numbers) { int returnValue = 0;
	 * String[] numbersArray = numbers.split(","); if (numbersArray.length > 2)
	 * { throw new
	 * RuntimeException("Up to 2 numbers separated by comma (,) are allowed"); }
	 * for (String number : numbersArray) { if (!number.trim().isEmpty()) { //
	 * After refactoring returnValue += Integer.parseInt(number); } } return
	 * returnValue; }
	 */
	/*
	 * public static int add(final String numbers) { int returnValue = 0;
	 * String[] numbersArray = numbers.split(","); // Removed after exception //
	 * if (numbersArray.length > 2) { // throw new
	 * RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
	 * // } for (String number : numbersArray) { if (!number.trim().isEmpty()) {
	 * // After refactoring returnValue += Integer.parseInt(number); } } return
	 * returnValue; }
	 */
	// number 5
	/*
	 * public static int add(final String numbers) { int returnValue = 0;
	 * String[] numbersArray = numbers.split(",|n"); // Added |n to the split
	 * regex for (String number : numbersArray) { if (!number.trim().isEmpty())
	 * { returnValue += Integer.parseInt(number.trim()); } } return returnValue;
	 * }
	 */
	// number 6 is working with no errors
	public static int add(final String numbers) {
		String delimiter = ",|n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers
					.substring(numbers.indexOf("n") + 1);
		}
		return add(numbersWithoutDelimiter, delimiter);
	}

	/*
	 * private static int add(final String numbers, final String delimiter) {
	 * int returnValue = 0; String[] numbersArray = numbers.split(delimiter);
	 * for (String number : numbersArray) { if (!number.trim().isEmpty()) {
	 * returnValue += Integer.parseInt(number.trim()); } }
	 * System.out.println("The return value is " +returnValue); return
	 * returnValue; }
	 */
	// number 7 does not like the list, so change compliance or add the code
	// adding this corrected its;
	// import java.util.ArrayList;
	// import java.util.List;
	/*
	 * private static int add(final String numbers, final String delimiter) {
	 * int returnValue = 0; String[] numbersArray = numbers.split(delimiter);
	 * List negativeNumbers = new ArrayList(); for (String number :
	 * numbersArray) { if (!number.trim().isEmpty()) { int numberInt =
	 * Integer.parseInt(number.trim()); if (numberInt < 0) {
	 * negativeNumbers.add(numberInt); } returnValue += numberInt; } } if
	 * (negativeNumbers.size() > 0) { throw new
	 * RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
	 * } return returnValue; }
	 */
	// number 8
	// 
	
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
		return add(numbersWithoutDelimiter, delimiter);
	}


}

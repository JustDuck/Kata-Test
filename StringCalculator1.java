package kataTestR1.java;

public class StringCalculator1 {

	public static void add(final String numbers) {
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException(
					"Up to 2 numbers separated by comma (,) are allowed");
		} else {
			for (String number : numbersArray) {
				Integer.parseInt(number); // If it is not a number, parseInt
											// will throw an exception
			}
		}
	}

}

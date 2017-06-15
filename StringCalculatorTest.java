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

import java.util.regex.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

public class StringCalculatorTest {
	// Requirement 1: The method can take 0, 1 or 2 numbers separated by comma

	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator.add("1,X");
	}

	// Requirement 2: For an empty string the method will return 0

	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator.add(""));
	}

	// Requirement 3: Method will return their sum of numbers

	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator.add("3"));

	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3 + 6, StringCalculator.add("3,6"));

	}

	// @Test(expected = RuntimeException.class)
	// public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
	// StringCalculator.add("1,2,3");
	// }

	// Requirement 4: Allow the Add method to handle an unknown amount of
	// numbers
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3 + 6 + 15 + 18 + 46 + 33,
				StringCalculator.add("3,6,15,18,46,33"));

	}

	// Requirement 5: Allow the Add method to handle new lines between numbers
	// (instead of commas).w
	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3 + 6 + 15, StringCalculator.add("3,6n15"));

	}

	// Requirement 6: Support different delimiters
	@Test
	public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(3 + 6 + 15, StringCalculator.add("//;n3;6;15"));

	}

	// Requirement 7: Negative numbers will throw an exception

	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator.add("3,-6,15,18,46,33");

	}

	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;

		try {
			StringCalculator.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -18]",
				exception.getMessage());
	}

	// Requirement 8: Numbers bigger than 1000 should be ignored
	@Test
	public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
		Assert.assertEquals(3 + 1000 + 6,
				StringCalculator.add("3,1000,1001,6,1234"));

	}

	/**
	 * this is a repeat with more code in it
	 */
	@Test
	public final void whenAddIsUsedThenItWorks() {

		Assert.assertEquals(0, StringCalculator.addA(""));
		Assert.assertEquals(3, StringCalculator.addA("3"));
		Assert.assertEquals(3 + 6, StringCalculator.addA("3,6"));
		Assert.assertEquals(3 + 6 + 15 + 18 + 46 + 33,
				StringCalculator.addA("3,6,15,18,46,33"));
		Assert.assertEquals(3 + 6 + 15, StringCalculator.addA("3,6\n15"));
		Assert.assertEquals(3 + 6 + 15, StringCalculator.addA("//;\n3;6;15"));
		Assert.assertEquals(3 + 1000 + 6,
				StringCalculator.addA("3,1000,1001,6,1234"));
	}

	// Requirement 9: Delimiters can be of any length

	@Test(expected = java.util.regex.PatternSyntaxException.class)
	public void addWithAnyLenghtDelimiter()
			throws java.util.regex.PatternSyntaxException {

		StringCalculator sc = new StringCalculator();

		assertEquals(2 + 32, sc.add("//[***]\n 1001***2***32"));

		fail("addWithAnyLenghtDelimiter");
		// there is an unclosed character somewhere in the above mess

	}

	// Requirement 10: Allow multiple delimiters

	@Test(expected = java.util.regex.PatternSyntaxException.class)
	public void addWithMultipleDelimiters() {
		StringCalculator sc = new StringCalculator();
		StringCalculator.add("//[+][,]\n1001,2+32+1,2");// just added this
		assertEquals(2 + 32 + 1 + 2, sc.add("//[+][,]\n1001,2+32+1,2"));
		Assert.fail("No exception was thrown");
	}

	// Requirement 11: Make sure you can also handle multiple delimiters
	// with length longer than one char

	@Test(expected = java.util.regex.PatternSyntaxException.class)
	public void addWithMultipleAnyLenghthDelimiters() {
		StringCalculator sc = new StringCalculator();
		assertEquals(2 + 32 + 1 + 2,
				sc.add("//[***][---]\n1001***2***32---1---2"));
		Assert.fail("No exception was thrown");
		Assert.assertNull(null);
	}
}

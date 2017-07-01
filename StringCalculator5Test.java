package kataTestR1.test;

import org.junit.Assert;

import kataTestR1.StringCalculator5;

import org.junit.Test;

public class StringCalculator5Test {
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator5.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator5.add("1,X");
	}
	
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator5.add(""));
	}
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator5.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator5.add("3,6"));
	}
	
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15+18+46+33, StringCalculator5.add("3,6,15,18,46,33"));
	}

	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15, StringCalculator5.add("3,6\n15"));
	}

}

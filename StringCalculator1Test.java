
package kataTestR1.test;

import kataTestR1.StringCalculator1;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculator1Test {
	
	
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator1.add("1,2,3");
		System.out.println("/n");
	}
	
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator1.add("1,2");
		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator1.add("1,X");
	}

}

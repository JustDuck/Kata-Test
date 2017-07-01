package kataTestR1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@Suite.SuiteClasses({

StringCalculator1Test.class, StringCalculator2Test.class,
		StringCalculator3Test.class, StringCalculator4Test.class,
		StringCalculator5Test.class, StringCalculator6Test.class,
		StringCalculator7Test.class, StringCalculator8Test.class,
		StringCalculatorTest.class })
/**
 * This file can be run either as an application or via junit test.
 * The main method creates the results from running each 
 * StringCalculatorTest.  Using two methods it provides the count and then 
 * totals the sum of all the tests that were run.
 *
 */
public class JunitTestSuite2 {

	public static void main(String[] args) {

		Result resultA = JUnitCore.runClasses(JunitTestSuite.class);
		Result result1 = JUnitCore.runClasses(StringCalculator1Test.class);
		Result result2 = JUnitCore.runClasses(StringCalculator2Test.class);
		Result result3 = JUnitCore.runClasses(StringCalculator3Test.class);
		Result result4 = JUnitCore.runClasses(StringCalculator4Test.class);
		Result result5 = JUnitCore.runClasses(StringCalculator5Test.class);
		Result result6 = JUnitCore.runClasses(StringCalculator6Test.class);
		Result result7 = JUnitCore.runClasses(StringCalculator7Test.class);
		Result result8 = JUnitCore.runClasses(StringCalculator8Test.class);
		Result result9 = JUnitCore.runClasses(StringCalculatorTest.class);

		for (Failure failure : resultA.getFailures()) {
			System.out.println(failure.toString());
			System.out.println("init error ");

		}

		for (Failure failure1 : result1.getFailures()) {
			System.out.println(failure1.toString());
			System.out.println(result1.wasSuccessful());
			System.out.println(" I doubt it errored");

		}

		int count = result1.getRunCount();
		int sum = 0;

		result1 = JUnitCore.runClasses(StringCalculator1Test.class);
		System.out.println(result1.wasSuccessful());
		System.out.println("the number of tests run for T1 = " + count);
		sum += count;

		result2 = JUnitCore.runClasses(StringCalculator2Test.class);
		count = result2.getRunCount();
		System.out.println("the number of tests run for T2 = " + count);
		sum += count;

		result3 = JUnitCore.runClasses(StringCalculator3Test.class);
		count = result3.getRunCount();
		System.out.println("the number of tests run for T3 = " + count);
		sum += count;

		result4 = JUnitCore.runClasses(StringCalculator4Test.class);
		count = result4.getRunCount();
		System.out.println("the number of tests run for T4 = " + count);
		sum += count;

		result5 = JUnitCore.runClasses(StringCalculator5Test.class);
		count = result5.getRunCount();
		System.out.println("the number of tests run for T5 = " + count);
		sum += count;

		result6 = JUnitCore.runClasses(StringCalculator6Test.class);
		count = result6.getRunCount();
		System.out.println("the number of tests run for T6 = " + count);
		sum += count;

		result7 = JUnitCore.runClasses(StringCalculator7Test.class);
		count = result7.getRunCount();
		System.out.println("the number of tests run for T7 = " + count);
		sum += count;

		result8 = JUnitCore.runClasses(StringCalculator8Test.class);
		count = result8.getRunCount();
		System.out.println("the number of tests run for T8 = " + count);
		sum += count;

		result9 = JUnitCore.runClasses(StringCalculatorTest.class);
		count = result9.getRunCount();
		System.out.println("the number of tests run for T All = " + count);
		sum += count;

		System.out.println("The total number of tests is = " + sum);

	}

}

// / From the console: java org.junit.runner.JUnitCore
// test.java.com.wordpress.technologyconversations.tddexamplewalkthrough.StringCalculator1Test 
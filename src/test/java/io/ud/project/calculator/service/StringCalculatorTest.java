package io.ud.project.calculator.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * {@code StringCalculatorTest} is the unit test class which holds test cases for {@code StringCalculator} class.
 *
 * @author <a href = "https://github.com/udayabharathi">@udayabharathi</a>
 * @since 2020-11-14
 */
@SuppressWarnings({"SimplifiableAssertion"})
public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_EmptyString_ShouldReturn0() {
        assertTrue("Empty String", stringCalculator.add("").equals(0));
    }

    @Test
    public void add_SingleNumber_ShouldReturnSameNumber() {
        assertTrue("Single Number", stringCalculator.add("1").equals(1));
    }

    @Test
    public void add_NumbersSplitByDelimiter_ShouldReturnSumOfNumbers() {
        assertTrue("Numbers split by delimiter", stringCalculator.add("1,2").equals(3));
    }

    @Test(expected = NullPointerException.class)
    public void add_NullInput_ShouldThrowNullPointerException() {
        stringCalculator.add(null);
    }
}
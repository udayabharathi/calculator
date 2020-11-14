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

    @Test(expected = NumberFormatException.class)
    public void add_InputWithOnlyDelimiter_ShouldThrowNumberFormatException() {
        stringCalculator.add(",");
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

    @Test
    public void add_UnknownNumberOfInputs_ShouldProcessAndReturnSum() {
        assertTrue("Unknown Number of Inputs", stringCalculator.add("1,2,3,4,5,6,7,8,9").equals(45));
    }

    @Test
    public void add_InputWithNewLineAndCommaAsDelimiter_ShouldProcessAndReturnSum() {
        assertTrue("New line and comma as Delimiter", stringCalculator.add("1,2\n3,4,5\n6,7,8\n9").equals(45));
    }

    @Test(expected = NumberFormatException.class)
    public void add_InputWithMultiDelimitersTogether_ShouldThrowNumberFormatException() {
        stringCalculator.add("1,\n2");
    }

    @Test
    public void add_CustomDelimiter_ShouldProcessAndReturnSum() {
        assertTrue("Custom Delimiter", stringCalculator.add("//;\n1;2;3;4").equals(10));
    }

    @Test
    public void add_CustomDelimiterWithNewLine_ShouldProcessAndReturnSum() {
        assertTrue("Custom Delimiter with new line", stringCalculator.add("//;\n1;2\n3;4").equals(10));
    }

    @Test(expected = NumberFormatException.class)
    public void add_CustomDelimiterWithExistingDelimiters_ShouldThrowNumberFormatException() {
        assertTrue("Custom Delimiter along with existing comma", stringCalculator.add("//;\n1\n2;3,4").equals(10));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add_NegativeNumbers_ShouldThrowUnsupportedOperationException() {
        stringCalculator.add("1,-2,3,4");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add_NegativeNumbersWithCustomDelimiter_ShouldThrowUnsupportedOperationException() {
        stringCalculator.add("//;\n1;-2;3\n4");
    }

    @Test
    public void add_NumbersGreaterThan1000_ShouldIgnoreNumbersMoreThan1000AndFindsSum() {
        assertTrue("Numbers more than 1000", stringCalculator.add("1,2,1001,1000").equals(1003));
    }

    @Test
    public void add_OpenArrayAsDelimiter_ShouldProcessAndReturnSum() {
        assertTrue("Open array character ('[') as delimiter", stringCalculator.add("//[\n1[2[3").equals(6));
    }

    @Test
    public void add_CloseArrayAsDelimiter_ShouldProcessAndReturnSum() {
        assertTrue("Open array character (']') as delimiter", stringCalculator.add("//]\n1]2]3").equals(6));
    }

    @Test
    public void add_MultiCharacterDelimiter_ShouldProcessAndReturnSum() {
        assertTrue("Multi Character Delimiter", stringCalculator.add("//[***]\n1***2***3").equals(6));
    }

    @Test
    public void add_MultiCharacterDelimiterWithOpenAndCloseArrayCharacters_ShouldProcessAndReturnSum() {
        assertTrue("Multi Character Delimiter with open and close array characters",
                stringCalculator.add("//[*[*[]*]\n1*[*[]*2*[*[]*3").equals(6));
    }
}
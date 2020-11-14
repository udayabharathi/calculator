package io.ud.project.calculator.service;

import java.util.Arrays;
import java.util.Objects;

/**
 * {@code StringCalculator} is a {@code Calculator} implementation that will have methods that processes String input
 * and returns Integer as response.
 *
 * @author <a href = "https://github.com/udayabharathi">@udayabharathi</a>
 * @since 2020-11-14
 */
public class StringCalculator implements Calculator<String, Integer> {

    private static final String DELIMITER = ",";

    /**
     * Processes the given single input and returns the response by adding all the numbers parsed from String
     * .
     *
     * @param input Input.
     * @return Integer
     */
    @Override
    public Integer add(String input) {
        if (Objects.requireNonNull(input, "Input cannot be null!").isEmpty()) return 0;
        return Arrays.stream(splitAndFetchNumbers(input)).sum();
    }

    /**
     * Splits and parses the String as int array
     *
     * @param input Input String.
     * @return int[]
     */
    private static int[] splitAndFetchNumbers(String input) {
        String[] numbersAsString = Objects.requireNonNull(input, "Input String cannot be null").split(DELIMITER);
        return Arrays.stream(numbersAsString).mapToInt(Integer::parseInt).toArray();
    }
}

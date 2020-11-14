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

    private static final String REGEX_NEWLINE = "\n";

    private static final Character NEWLINE = '\n';

    private static final String CUSTOM_DELIMITER_PATTERN = "//";

    /**
     * Processes the given single input and returns the response by adding all the numbers parsed from the given String.
     *
     * @param input Input.
     * @return Integer
     */
    @Override
    public Integer add(String input) {
        if (Objects.requireNonNull(input, "Input cannot be null!").isEmpty()) return 0;
        if (isCustomDelimiterEnabled(input))
            return Arrays.stream(splitAndFetchNumbers(fetchNumberInput(input), fetchCustomDelimiter(input))).sum();
        return Arrays.stream(splitAndFetchNumbers(input)).sum();
    }

    /**
     * Fetches list of numbers from the input String.
     *
     * @param input Input String.
     * @return String
     */
    private static String fetchNumberInput(String input) {
        return input.substring(input.indexOf(NEWLINE) + 1);
    }

    /**
     * Fetches custom delimiter.
     *
     * @param input Input String.
     * @return String
     */
    private static String fetchCustomDelimiter(String input) {
        return input.substring(2, input.indexOf(NEWLINE));
    }

    /**
     * Checks if custom delimiter is enabled.
     *
     * @param input Input String.
     * @return boolean
     */
    private static boolean isCustomDelimiterEnabled(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PATTERN);
    }

    /**
     * Splits and parses the String as int array
     *
     * @param input Input String.
     * @return int[]
     */
    private static int[] splitAndFetchNumbers(String input) {
        input = input.replaceAll(REGEX_NEWLINE, DELIMITER);
        String[] numbersAsString = input.split(DELIMITER);
        if (numbersAsString.length == 0) throw new NumberFormatException("Invalid String provided!");
        return Arrays.stream(numbersAsString).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * Splits and parses the String as int array
     *
     * @param input     Input String.
     * @param delimiter Custom delimiter.
     * @return int[]
     */
    private static int[] splitAndFetchNumbers(String input, String delimiter) {
        input = input.replaceAll(REGEX_NEWLINE, delimiter);
        String[] numbersAsString = input.split(delimiter);
        if (numbersAsString.length == 0) throw new NumberFormatException("Invalid String provided!");
        return Arrays.stream(numbersAsString).mapToInt(Integer::parseInt).toArray();
    }
}

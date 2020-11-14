package io.ud.project.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@code Calculator} is an interface which has default methods which can be implemented based on Input and Output
 * type requirements.
 *
 * @param <InputType>  Input data type.
 * @param <OutputType> Output data type.
 * @author <a href = "https://github.com/udayabharathi">@udayabharathi</a>
 * @since 2020-11-14
 */
@SuppressWarnings("unused")
public interface Calculator<InputType, OutputType> {

    Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    /**
     * Processes the given single input and returns the response.
     *
     * @param input Input.
     * @return OutputType
     */
    default OutputType add(InputType input) {
        LOGGER.info("Not Implemented!");
        return null;
    }
}

package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";

    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

}

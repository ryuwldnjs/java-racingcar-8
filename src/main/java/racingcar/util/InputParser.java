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

    public static int parseRounds(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}

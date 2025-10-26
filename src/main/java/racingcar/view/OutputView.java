package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String POSITION_INDICATOR = "-";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRoundResult(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + NAME_POSITION_DELIMITER + generatePositionIndicator(positions.get(i)));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winnerNames));
    }

    private static String generatePositionIndicator(int position) {
        return POSITION_INDICATOR.repeat(position);
    }

}
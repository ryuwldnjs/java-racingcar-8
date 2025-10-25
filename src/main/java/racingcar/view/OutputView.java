package racingcar.view;

import racingcar.domain.Car;

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

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + NAME_POSITION_DELIMITER + generatePositionIndicator(car.getPosition()));
        });
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winnerNames));
    }

    private static String generatePositionIndicator(int position) {
        return POSITION_INDICATOR.repeat(position);
    }



}
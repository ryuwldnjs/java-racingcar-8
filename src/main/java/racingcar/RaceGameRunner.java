package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceGame;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameRunner {
    public static void run() {
        List<String> carNames = InputParser.parseCarNames(InputView.readCarNames());
        int rounds = InputParser.parseRounds(InputView.readRounds());
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

        List<Car> cars = carNames.stream().map(Car::new).toList();
        RaceGame raceGame = new RaceGame(cars);

        playRace(raceGame, cars, rounds);
        printWinners(cars);
    }

    private static void playRace(RaceGame raceGame, List<Car> cars, int rounds) {
        OutputView.printResultHeader();
        for (int i = 0; i < rounds; i++) {
            raceGame.playRound();
            OutputView.printRoundResult(
                    cars.stream().map(Car::getName).toList(),
                    cars.stream().map(Car::getPosition).toList()
            );
        }
    }

    private static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        OutputView.printWinners(winners);
    }
}
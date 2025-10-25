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

        List<Car> cars = carNames.stream().map(Car::new).toList();
        RaceGame raceGame = new RaceGame(cars);

        playRace(raceGame, cars, rounds);
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

}
package racingcar;

import racingcar.domain.RaceGame;
import racingcar.domain.Rounds;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameRunner {

    public static void run() {
        List<String> carNames = InputParser.parseCarNames(InputView.readCarNames());
        Rounds rounds = new Rounds(InputParser.parseRounds(InputView.readRounds()));

        RaceGame raceGame = RaceGame.from(carNames);

        playRace(raceGame, rounds);
        OutputView.printWinners(raceGame.getWinners());
    }

    private static void playRace(RaceGame raceGame, Rounds rounds) {
        OutputView.printResultHeader();
        for (int i = 0; i < rounds.value(); i++) {
            raceGame.playRound();
            OutputView.printRoundResult(raceGame.getCarNames(), raceGame.getCarPositions());
        }
    }

}
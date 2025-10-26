package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUNDS_SENTENCE = "시도할 횟수는 몇 회인가요?";

    public static String readCarNames() {
        System.out.println(CAR_NAMES_SENTENCE);
        return Console.readLine();
    }

    public static String readRounds() {
        System.out.println(ROUNDS_SENTENCE);
        return Console.readLine();
    }
}
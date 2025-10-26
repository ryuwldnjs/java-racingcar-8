package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (randomNumber >= MIN_MOVE_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
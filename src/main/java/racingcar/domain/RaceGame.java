package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;

    public RaceGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }


    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
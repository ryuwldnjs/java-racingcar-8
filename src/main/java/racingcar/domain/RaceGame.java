package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private final List<Car> cars;

    public RaceGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static RaceGame from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new RaceGame(cars);
    }

    public void playRound() {
        cars.forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }
    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
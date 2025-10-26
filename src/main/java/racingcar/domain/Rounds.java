package racingcar.domain;

public record Rounds(int value) {

    public Rounds {
        validate(value);
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
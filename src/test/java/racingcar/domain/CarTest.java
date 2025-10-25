package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest extends NsTest {

    @DisplayName("자동차 이름을 저장한다")
    @Test
    void createCarWithName() {
        // given & when
        Car car = new Car("pobi");

        // then
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void createCarWithValidName(String name) {
        // given & when & then
        assertThat(new Car(name).getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "toolongname"})
    void createCarWithTooLongName(String name) {
        // given & when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    @Test
    void createCarWithNullName() {
        // given & when & then
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값");
    }

    @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void createCarWithEmptyName(String name) {
        // given & when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값");
    }

    @DisplayName("자동차의 초기 위치는 0이다")
    @Test
    void initialPosition() {
        // given & when
        Car car = new Car("pobi");

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("무작위 값이 4 이상이면 전진한다")
    @Test
    void moveForwardWhenRandomNumberIsGreaterThanOrEqualTo4() {
        // given
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");

                    // when
                    car.move();

                    // then
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                4, 5, 6, 7, 8, 9
        );
    }

    @DisplayName("무작위 값이 3 이하면 정지한다")
    @Test
    void stopWhenRandomNumberIsLessThan4() {
        // given
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");

                    // when
                    car.move();

                    // then
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                0, 1, 2, 3
        );
    }

    @DisplayName("전진을 여러 번 할 수 있다")
    @Test
    void moveMultipleTimes() {
        // given
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");

                    // when
                    car.move();
                    car.move();
                    car.move();

                    // then
                    assertThat(car.getPosition()).isEqualTo(3);
                },
                4, 5, 6
        );
    }

    @Override
    public void runMain() {
        // CarTest는 단위 테스트이므로 runMain 불필요
    }
}
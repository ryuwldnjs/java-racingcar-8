package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

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
}
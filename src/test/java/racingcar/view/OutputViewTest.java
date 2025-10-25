package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @DisplayName("실행 결과 헤더를 출력한다")
    @Test
    void printResultHeader() {
        assertSimpleTest(() -> {
            // when
            OutputView.printResultHeader();

            // then
            assertThat(output()).contains("실행 결과");
        });
    }

    @DisplayName("라운드 결과를 출력한다")
    @Test
    void printRoundResult() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("");
                    Car car1 = new Car("pobi");
                    Car car2 = new Car("woni");
                    car1.move();
                    car2.move();

                    // when
                    OutputView.printRoundResult(List.of(car1, car2));

                    // then
                    assertThat(output()).contains("pobi : -");
                    assertThat(output()).contains("woni :");
                    assertThat(output()).doesNotContain("woni : -");
                },
                4, 3
        );
    }

    @DisplayName("여러 자동차의 라운드 결과를 출력한다")
    @Test
    void printRoundResultWithMultipleCars() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("");
                    Car car1 = new Car("pobi");
                    Car car2 = new Car("woni");
                    Car car3 = new Car("jun");
                    car1.move();
                    car1.move();
                    car2.move();

                    // when
                    OutputView.printRoundResult(List.of(car1, car2, car3));

                    // then
                    assertThat(output()).contains("pobi : --");
                    assertThat(output()).contains("woni : -");
                    assertThat(output()).contains("jun :");
                },
                4, 5, 4, 3
        );
    }


    @DisplayName("위치가 0인 자동차는 이동 표시가 없다")
    @Test
    void printRoundResult_NoPosition() {
        assertSimpleTest(() -> {
            run("");
            Car car = new Car("pobi");

            // when
            OutputView.printRoundResult(List.of(car));

            // then
            assertThat(output()).contains("pobi :");
            assertThat(output()).doesNotContain("pobi : -");
        });
    }

    @Override
    public void runMain() {
        // OutputViewTest는 단위 테스트이므로 runMain 불필요
    }
}
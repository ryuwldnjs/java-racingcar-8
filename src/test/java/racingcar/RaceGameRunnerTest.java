package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceGameRunnerTest extends NsTest {

    @DisplayName("시도 횟수가 0이면 예외가 발생한다")
    @Test
    void validateRounds_Zero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 양수여야 합니다")
        );
    }

    @DisplayName("시도 횟수가 음수면 예외가 발생한다")
    @Test
    void validateRounds_Negative() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 양수여야 합니다")
        );
    }

    @DisplayName("단독 우승자를 출력한다")
    @Test
    void printWinners_Single() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                4, 3
        );
    }

    @DisplayName("공동 우승자를 출력한다")
    @Test
    void printWinners_Multiple() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                4, 4, 3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
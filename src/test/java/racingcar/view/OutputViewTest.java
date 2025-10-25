package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertSimpleTest(() -> {
            // given
            List<String> carNames = List.of("pobi", "woni");
            List<Integer> positions = List.of(1, 0);

            // when
            OutputView.printRoundResult(carNames, positions);

            // then
            assertThat(output()).contains("pobi : -");
            assertThat(output()).contains("woni :");
            assertThat(output()).doesNotContain("woni : -");
        });
    }

    @DisplayName("여러 자동차의 라운드 결과를 출력한다")
    @Test
    void printRoundResultWithMultipleCars() {
        assertSimpleTest(() -> {
            // given
            List<String> carNames = List.of("pobi", "woni", "jun");
            List<Integer> positions = List.of(2, 1, 0);

            // when
            OutputView.printRoundResult(carNames, positions);

            // then
            assertThat(output()).contains("pobi : --");
            assertThat(output()).contains("woni : -");
            assertThat(output()).contains("jun :");
        });
    }

    @DisplayName("우승자를 출력한다 - 단독 우승")
    @Test
    void printWinners_Single() {
        assertSimpleTest(() -> {
            // given
            List<String> winnerNames = List.of("pobi");

            // when
            OutputView.printWinners(winnerNames);

            // then
            assertThat(output()).contains("최종 우승자 : pobi");
        });
    }

    @DisplayName("우승자를 출력한다 - 공동 우승")
    @Test
    void printWinners_Multiple() {
        assertSimpleTest(() -> {
            // given
            List<String> winnerNames = List.of("pobi", "jun");

            // when
            OutputView.printWinners(winnerNames);

            // then
            assertThat(output()).contains("최종 우승자 : pobi, jun");
        });
    }

    @DisplayName("위치가 0인 자동차는 이동 표시가 없다")
    @Test
    void printRoundResult_NoPosition() {
        assertSimpleTest(() -> {
            // given
            List<String> carNames = List.of("pobi");
            List<Integer> positions = List.of(0);

            // when
            OutputView.printRoundResult(carNames, positions);

            // then
            assertThat(output()).contains("pobi :");
            assertThat(output()).doesNotContain("pobi : -");
        });
    }

    @DisplayName("위치에 따라 정확한 개수의 하이픈을 출력한다")
    @Test
    void printRoundResult_PositionIndicator() {
        assertSimpleTest(() -> {
            // given
            List<String> carNames = List.of("pobi");
            List<Integer> positions = List.of(5);

            // when
            OutputView.printRoundResult(carNames, positions);

            // then
            assertThat(output()).contains("pobi : -----");
        });
    }

    @Override
    public void runMain() {
        // OutputViewTest는 단위 테스트이므로 runMain 불필요
    }
}
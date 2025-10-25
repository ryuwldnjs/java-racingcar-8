package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @DisplayName("자동차 이름을 입력받는다")
    @Test
    void readCarNames() {
        assertSimpleTest(() -> {
            // when
            run("pobi,woni,jun");
            String result = InputView.readCarNames();

            // then
            assertThat(result).isEqualTo("pobi,woni,jun");
        });
    }

    @DisplayName("자동차 이름 입력 시 안내 문구를 출력한다")
    @Test
    void readCarNamesPrintsPrompt() {
        assertSimpleTest(() -> {
            // when
            run("pobi");
            InputView.readCarNames();

            // then
            assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        });
    }

    @DisplayName("시도 횟수를 입력받는다")
    @Test
    void readRounds() {
        assertSimpleTest(() -> {
            // when
            run("5");
            String result = InputView.readRounds();

            // then
            assertThat(result).isEqualTo("5");
        });
    }

    @DisplayName("시도 횟수 입력 시 안내 문구를 출력한다")
    @Test
    void readRoundsPrintsPrompt() {
        assertSimpleTest(() -> {
            // when
            run("5");
            InputView.readRounds();

            // then
            assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
        });
    }

    @DisplayName("공백이 포함된 자동차 이름을 입력받는다")
    @Test
    void readCarNamesWithSpaces() {
        assertSimpleTest(() -> {
            // when
            run(" pobi , woni , jun ");
            String result = InputView.readCarNames();

            // then
            assertThat(result).isEqualTo(" pobi , woni , jun ");
        });
    }

    @Override
    public void runMain() {
        // InputViewTest는 단위 테스트이므로 runMain 불필요
    }
}
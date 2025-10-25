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



    @Override
    public void runMain() {
        // OutputViewTest는 단위 테스트이므로 runMain 불필요
    }
}
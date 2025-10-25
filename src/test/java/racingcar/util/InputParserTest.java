package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @DisplayName("쉼표로 구분된 자동차 이름을 파싱한다")
    @Test
    void parseCarNames() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> result = InputParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("자동차 이름의 공백을 제거한다")
    @Test
    void parseCarNames_WithSpaces() {
        // given
        String input = " pobi , woni , jun ";

        // when
        List<String> result = InputParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("자동차 이름이 하나만 입력된 경우")
    @Test
    void parseCarNames_WithSingleName() {
        // given
        String input = "pobi";

        // when
        List<String> result = InputParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("pobi");
    }

}
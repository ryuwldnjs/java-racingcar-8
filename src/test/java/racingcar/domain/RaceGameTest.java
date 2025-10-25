package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest extends NsTest {

    @DisplayName("여러 자동차를 관리한다")
    @Test
    void createRaceGameWithMultipleCars() {
        // given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        // when
        RaceGame raceGame = new RaceGame(cars);

        // then
        assertThat(raceGame.getCars()).hasSize(3);
        assertThat(raceGame.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(raceGame.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(raceGame.getCars().get(2).getName()).isEqualTo("jun");
    }



    @Override
    public void runMain() {
        // RaceGameTest는 단위 테스트이므로 runMain 불필요
    }
}

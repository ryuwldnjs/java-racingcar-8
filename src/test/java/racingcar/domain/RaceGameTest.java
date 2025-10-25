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

    @DisplayName("한 라운드 진행 시 모든 자동차가 이동한다")
    @Test
    void playRound() {
        // given
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(
                            new Car("pobi"),
                            new Car("woni"),
                            new Car("jun")
                    );
                    RaceGame raceGame = new RaceGame(cars);

                    // when
                    raceGame.playRound();

                    // then
                    List<Car> result = raceGame.getCars();
                    assertThat(result.get(0).getPosition()).isEqualTo(1);
                    assertThat(result.get(1).getPosition()).isEqualTo(1);
                    assertThat(result.get(2).getPosition()).isEqualTo(0);
                },
                4, 5, 3
        );
    }

    @DisplayName("여러 라운드를 진행할 수 있다")
    @Test
    void playMultipleRounds() {
        // given
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(
                            new Car("pobi"),
                            new Car("woni")
                    );
                    RaceGame raceGame = new RaceGame(cars);

                    // when
                    raceGame.playRound();
                    raceGame.playRound();
                    raceGame.playRound();

                    // then
                    List<Car> result = raceGame.getCars();
                    assertThat(result.get(0).getPosition()).isEqualTo(3);
                    assertThat(result.get(1).getPosition()).isEqualTo(2);
                },
                4, 5, 6,  // pobi: 3회 전진
                4, 5, 3   // woni: 2회 전진
        );
    }

    @DisplayName("getCars는 deep copy을 반환한다")
    @Test
    void getCarsReturnsDefensiveCopy() {
        // given
        List<Car> cars = List.of(new Car("pobi"));
        RaceGame raceGame = new RaceGame(cars);

        // when
        List<Car> result1 = raceGame.getCars();
        List<Car> result2 = raceGame.getCars();

        // then
        assertThat(result1).isNotSameAs(result2);
        assertThat(result1).isNotSameAs(cars);
    }

    @DisplayName("자동차가 없어도 RaceGame을 생성할 수 있다")
    @Test
    void createRaceGameWithEmptyCars() {
        // given
        List<Car> cars = List.of();

        // when
        RaceGame raceGame = new RaceGame(cars);

        // then
        assertThat(raceGame.getCars()).isEmpty();
    }

    @Override
    public void runMain() {
        // RaceGameTest는 단위 테스트이므로 runMain 불필요
    }
}

package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.NextStepCar;
import racingcar.domain.cars.Cars;
import racingcar.domain.factory.NextStepCarFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class RacingCarGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void CARS_객체_정상_생성_확인() {
        Cars cars = new NextStepCarFactory().makeCar("car1, car2");
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.cars.getCar(0);

        assertEquals("car1", racingCarGame.cars.getCar(0).getName(),"설정된 첫번째 자동차는 'car1'이여야 합니다.");
        assertEquals("car2", racingCarGame.cars.getCar(1).getName(),"설정된 첫번째 자동차는 'car2'이여야 합니다.");

        assertTrue(racingCarGame.cars.getCar(0) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
        assertTrue(racingCarGame.cars.getCar(1) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
    }

    @Test
    void 게임_진행_정상_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Cars cars = new NextStepCarFactory().makeCar("car1, car2");
                    RacingCarGame racingCarGame = new RacingCarGame(cars);
                    racingCarGame.play();

                    assertThat(outputStreamCaptor.toString().contains("car1 : -, car2 : "));
                },
                8,new Integer[]{3}
        );
    }

    @Test
    void 우승자_정상_반환_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Cars cars = new NextStepCarFactory().makeCar("car1, car2");
                    RacingCarGame racingCarGame = new RacingCarGame(cars);
                    racingCarGame.play();

                    assertThat(outputStreamCaptor.toString().contains("최종 우승자는 car1 입니다."));
                },
                8,new Integer[]{3}
        );
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
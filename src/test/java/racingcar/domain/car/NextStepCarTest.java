package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.domain.engine.NextStepEngine;
import racingcar.generator.NextStepFuelGenerator;
import racingcar.validator.name.NextStepValidatorName;
import racingcar.validator.name.ValidatorName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class NextStepCarTest {

    @Test
    void FUEL_정상_설정_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatCode(
                        () -> {
                            Car car = new NextStepCar("test");
                            car.move();
                        }
                ).doesNotThrowAnyException(),
                9
        );
    }

    @Test
    void FUEL_비정상_시_에러_발생_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            Car car = new NextStepCar("test");
                            car.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class),
                -1
        );
    }

    @Test
    void 전진_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Car car = new NextStepCar("test");
                    car.move();
                    assertEquals(1, car.getLocation(),"차의 위치는 1이여야 합니다.");
                },
                8
        );
    }

    @Test
    void 이름_정상_설정_여부_검증() {
        assertThatCode(
                () -> {
                    Car car = new NextStepCar("test");
                }
        ).doesNotThrowAnyException();
    }

    @Test
    void 이름_비정상_시_에러_발생_여부_검증() {
        assertThatThrownBy(
                () -> {
                    Car car = new NextStepCar("carName");
                }
        ) .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 출력부_포맷_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    Car car = new NextStepCar("test");
                    car.move();
                    assertEquals("test : -", car.toString(),"출력값이 'test : -'여야 합니다.");
                },
                8
        );
    }

}
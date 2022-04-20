package racingcar.domain.engine;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.generator.FuelGenerator;
import racingcar.generator.NextStepFuelGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class NextStepEngineTest {

    @Test
    void 지정값_멈춤_확인() {
        NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
        boolean result = engine.gearShift(2);
        assertFalse(result);
    }

    @Test
    void 지정값_전진_확인() {
        NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
        boolean result = engine.gearShift(7);
        assertTrue(result);
    }

    @Test
    void 랜덤값_멈춤_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                    boolean result = engine.move();
                    assertFalse(result);
                },
                1
        );
    }

    @Test
    void 랜덤값_전진_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                    boolean result = engine.move();
                    assertTrue(result);
                },
                5
        );
    }

    @Test
    void 범위이하값_에러_확인(){
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                            engine.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class),
                -1
        );
    }

    @Test
    void 범위이상값_에러_확인(){
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                            engine.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class),
                10
        );
    }

}
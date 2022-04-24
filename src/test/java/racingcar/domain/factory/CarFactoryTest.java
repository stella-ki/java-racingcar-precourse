package racingcar.domain.factory;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.engine.NextStepEngine;
import racingcar.generator.NextStepFuelGenerator;
import racingcar.validator.name.NextStepValidatorName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void 자동차_갯수_0_에러_확인() {
        assertThatThrownBy(
                () -> new CarFactory()
                        .setEngine(new NextStepEngine(
                                new NextStepFuelGenerator()
                        ))
                        .setValidatorName(new NextStepValidatorName())
                        .makeCar("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_에러_확인() {
        assertThatThrownBy(
                () -> new CarFactory()
                        .setEngine(new NextStepEngine(
                                new NextStepFuelGenerator()
                        ))
                        .setValidatorName(new NextStepValidatorName())
                        .makeCar("carcarcar, car2")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ENGINE_NULL_에러_확인() {
        assertThatThrownBy(
                () -> new CarFactory()
                        .setValidatorName(new NextStepValidatorName())
                        .makeCar("car1,car2")
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void VALIDATOR_NAME_에러_확인() {
        assertThatThrownBy(
                () -> new CarFactory()
                        .setEngine(new NextStepEngine(
                                new NextStepFuelGenerator()
                        ))
                        .makeCar("car1,car2")
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 리스트_정상_반환_확인() {
        Cars cars = new CarFactory()
                .setEngine(new NextStepEngine(
                        new NextStepFuelGenerator()
                ))
                .setValidatorName(new NextStepValidatorName())
                .makeCar("car1,car2");

        assertEquals("car1", cars.getCars().get(0).getName(),"설정된 첫번째 자동차는 'car1'이여야 합니다.");
        assertEquals("car2", cars.getCars().get(1).getName(),"설정된 첫번째 자동차는 'car2'이여야 합니다.");

        assertNotNull(cars.getCars().get(0), "설정된 자동차는 car 객체여야 합니다.");
        assertNotNull(cars.getCars().get(1), "설정된 자동차는 car 객체여야 합니다.");
    }
}
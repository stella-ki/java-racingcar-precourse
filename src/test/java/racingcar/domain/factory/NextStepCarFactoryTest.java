package racingcar.domain.factory;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.NextStepCar;
import racingcar.domain.cars.Cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NextStepCarFactoryTest {

    @Test
    void 자동차_갯수_0_에러_확인() {
        assertThatThrownBy(
                () -> new NextStepCarFactory()
                        .makeCar("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_에러_확인() {
        assertThatThrownBy(
                () -> new NextStepCarFactory()
                        .makeCar("carcarcar, car2")
        ).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 리스트_정상_반환_확인() {
        Cars cars = new NextStepCarFactory()
                .makeCar("car1,car2");

        assertEquals("car1", cars.getCars().get(0).getName(),"설정된 첫번째 자동차는 'car1'이여야 합니다.");
        assertEquals("car2", cars.getCars().get(1).getName(),"설정된 첫번째 자동차는 'car2'이여야 합니다.");

        assertTrue(cars.getCars().get(0) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
        assertTrue(cars.getCars().get(1) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");

    }

}
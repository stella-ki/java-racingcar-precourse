package racingcar.domain.car.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarLocationTest {

    @Test
    void 전진_후_정상_출력_확인() {
        CarLocation carLocation = new CarLocation();
        carLocation.moveForward();
        carLocation.moveForward();

        assertEquals("--", carLocation.toString(), "'-'을 반환해야 합니다.");
    }

    @Test
    void 길이_정상_반환_확인() {
        CarLocation carLocation = new CarLocation();
        carLocation.moveForward();

        assertEquals(1, carLocation.getLocation(), "1을 반환해야 합니다.");
    }

    @Test
    void 값_정상_반환_확인() {
        CarLocation carLocation = new CarLocation();
        assertEquals("", carLocation.toString(), "빈칸을 반환해야 합니다.");

        carLocation.moveForward();
        carLocation.moveForward();

        assertEquals("--", carLocation.toString(), "'-'을 반환해야 합니다.");
    }
}
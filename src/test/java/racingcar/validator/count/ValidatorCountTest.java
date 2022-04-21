package racingcar.validator.count;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorCountTest {

    @Test
    void 비정상_INPUT_검증() {
        assertThatThrownBy(
                () -> {
                    final byte[] buf = String.join("\n", new String[]{"e"}).getBytes();
                    System.setIn(new ByteArrayInputStream(buf));

                    ValidatorCount validatorCount = new ValidatorCount();
                    validatorCount.validateCnt();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_INPUT_검증() {
        final byte[] buf = String.join("\n", new String[]{"3"}).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        ValidatorCount validatorCount = new ValidatorCount();
        int result = validatorCount.validateCnt();

        assertEquals(3, result, "숫자 3을 반환해야 합니다.");
    }
}
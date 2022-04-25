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
                    consoleInput(new String[]{"e"});

                    ValidatorCount validatorCount = new ValidatorCount();
                    validatorCount.validateCnt();
                }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘못된 값을 입력하셨습니다.(정수 입력)");
    }

    @Test
    void 정상_INPUT_검증() {
        consoleInput(new String[]{"3"});

        ValidatorCount validatorCount = new ValidatorCount();
        int result = validatorCount.validateCnt();

        assertEquals(3, result, "숫자 3을 반환해야 합니다.");
    }

    public void consoleInput(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
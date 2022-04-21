package racingcar.validator.name;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NextStepValidatorNameTest {

    @Test
    void 비정상_INPUT_검증() {
        assertThatThrownBy(
                () -> {
                    ValidatorName validatorName = new NextStepValidatorName();
                    validatorName.validateCarsName("carname");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_INPUT_검증() {
        assertThatCode(
                () -> {
                    ValidatorName validatorName = new NextStepValidatorName();
                    validatorName.validateCarsName("card");
                }
        ).doesNotThrowAnyException();
    }
}
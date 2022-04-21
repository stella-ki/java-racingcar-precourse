package racingcar.validator.name;

import racingcar.config.Config;

public class NextStepValidatorName implements ValidatorName{

    @Override
    public void validateCarsName(String carsStr) throws IllegalArgumentException{
        if(carsStr.length() > Config.MAX_NAME_LENGTH){
            throw new IllegalArgumentException("[ERROR] 이름의 길이가 잘못되었습니다.");
        }
    }
}

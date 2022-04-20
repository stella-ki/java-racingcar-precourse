package racingcar.domain.engine;

import racingcar.config.Config;
import racingcar.generator.FuelGenerator;

public class NextStepEngine extends Engine{

    public NextStepEngine(FuelGenerator fuelGenerator){
        this.fuelGenerator = fuelGenerator;
    }

    public boolean gearShift(int value){
        if(value > Config.MAX_FUAL_VALUE){
            throw new IllegalArgumentException();
        }
        return value >= Config.MOVE_FORWARD_FUAL_VALUE;
    }
}

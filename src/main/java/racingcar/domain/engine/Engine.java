package racingcar.domain.engine;

import racingcar.generator.FuelGenerator;

public abstract class Engine {

    FuelGenerator fuelGenerator;

    public boolean move(){
        int value = fuelGenerator.generateFuel();
        return gearShift(value);
    }

    public abstract boolean gearShift(int value);
}

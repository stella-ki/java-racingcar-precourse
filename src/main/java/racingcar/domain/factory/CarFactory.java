package racingcar.domain.factory;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.engine.Engine;
import racingcar.validator.name.ValidatorName;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private Engine engine;
    private ValidatorName validator;

    public CarFactory setEngine(Engine engine){
        this.engine = engine;
        return this;
    }

    public CarFactory setValidatorName(ValidatorName validator){
        this.validator = validator;
        return this;
    }

    public Cars makeCar(String input) throws IllegalArgumentException {
        List<Car> carList = new ArrayList<>();
        String[] split = input.split(",");

        if (split.length < 1) {
            System.out.println("경주할 자동차를 1대 이상 입력해 주세요.");
        }

        for (String name : split) {
            carList.add(getCar(name));
        }

        return new Cars(carList);
    }

    public Car getCar(String name){
        return new Car(name, engine, validator);
    }

}

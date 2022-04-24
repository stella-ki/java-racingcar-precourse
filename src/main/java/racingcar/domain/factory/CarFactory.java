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
        if (!input.contains(",")) {
            throw new IllegalArgumentException("경주할 자동차를 1대 이상 입력해 주세요.");
        }

        List<Car> carList = new ArrayList<>();
        String[] split = input.split(",");

        for (String name : split) {
            carList.add(getCar(name.trim()));
        }

        return new Cars(carList);
    }

    public Car getCar(String name){
        if(engine == null){
            throw new IllegalStateException("Engine을 설정해주세요.");
        }
        if(validator == null){
            throw new IllegalStateException("이름 검증 validator를 설정해주세요.");
        }
        return new Car(name, engine, validator);
    }

}

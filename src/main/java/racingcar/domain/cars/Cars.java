package racingcar.domain.cars;

import racingcar.domain.car.Car;
import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}

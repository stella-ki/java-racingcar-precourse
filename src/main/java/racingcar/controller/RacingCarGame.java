package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

public class RacingCarGame {

    Cars cars;

    public RacingCarGame(Cars cars){
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars.getCars()){
            car.move();
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public String findWinner() {
        int winnerCnt = cars.getMaxLocation();

        StringBuilder sb = new StringBuilder();
        sb.append(cars.getCar(0).getName());

        int index = 1;
        Car car = cars.getCar(index);

        while(car.getLocation() == winnerCnt){
            sb.append(String.format(", %s",  car.getName()));
        }

        return sb.toString();
    }

}

package racingcar.controller;

import racingcar.config.Message;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

public class RacingCarGame {

    Cars cars;

    public RacingCarGame setCars(Cars cars) {
        this.cars = cars;
        return this;
    }

    public void checkPrepareCars(){
        if(cars == null){
            throw new IllegalStateException(Message.ERROR_CARS_NULL);
        }
    }

    public void play() {
        checkPrepareCars();

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
            sb.append(String.format(Message.FORMAT_WINNER_EACH,  car.getName()));
        }

        return sb.toString();
    }

}

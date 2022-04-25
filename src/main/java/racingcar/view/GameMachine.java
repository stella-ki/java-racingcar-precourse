package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarGame;
import racingcar.domain.factory.CarFactory;
import racingcar.validator.count.ValidatorCount;

public class GameMachine {
    RacingCarGame game;
    CarFactory carFactory;

    public GameMachine setCarFactory(CarFactory carFactory){
        this.carFactory = carFactory;
        return this;
    }

    public void checkPrepareFactory() throws IllegalStateException{
        if(carFactory == null){
            throw new IllegalStateException("Car factory가 설정되어야 합니다.");
        }
    }

    public void run(){
        try {
            checkPrepareFactory();

            processGame();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void processGame(){
        String input = inputCars();
        int gameCnt = inputCnt();

        game = new RacingCarGame(carFactory.makeCar(input));

        playGames(gameCnt);

        String winner = game.findWinner();

        printWinner(winner);
    }

    public String inputCars() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println(input);

        return input;
    }

    public int inputCnt() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇 회인가요?");
        return (new ValidatorCount()).validateCnt();
    }

    public void playGames(int gameCnt){
        for (int i = 0; i< gameCnt; i++){
            game.play();
        }
    }

    public void printWinner(String winner){
        System.out.printf("최종 우승자는 %s 입니다.%n", winner);
    }
}

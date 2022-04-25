package racingcar;

import racingcar.domain.factory.NextStepCarFactory;
import racingcar.view.GameMachine;

public class Application {

    public static void main(String[] args) {
        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .run();
    }


}

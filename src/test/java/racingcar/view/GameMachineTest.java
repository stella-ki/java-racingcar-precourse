package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGame;
import racingcar.domain.factory.NextStepCarFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class GameMachineTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void INPUT_COUNT_비정상_범위_테스트() {
        consoleInput(new String[]{"car1, car2", "10"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] 랜덤값의 범위를 벗어났습니다."));
    }

    @Test
    void INPUT_COUNT_비정상_에러_테스트() {
        consoleInput(new String[]{"car1, car2", "F"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] 잘못된 값을 입력하셨습니다."));
    }

    @Test
    void INPUT_CAR_비정상_이름_길이_에러_테스트() {
        consoleInput(new String[]{"carcarcar, car2", "1"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] 이름의 길이가 잘못되었습니다."));
    }


    @Test
    void INPUT_CAR_비정상_개수_에러_테스트() {
        consoleInput(new String[]{"", "1"});

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] 경주할 자동차를 1대 이상 입력해 주세요."));
    }

    @Test
    void 필수_입력_파라메터_셋팅_에러_테스트() {
        consoleInput(new String[]{"car1, car2", "1"});

        new GameMachine()
                .setRacingCarGame(
                        new RacingCarGame()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] Car factory가 설정되어야 합니다."));

        new GameMachine()
                .setCarFactory(
                        new NextStepCarFactory()
                )
                .run();

        assertThat(outputStreamCaptor.toString().contains("[ERROR] Racing car Game이 설정되어야 합니다."));
    }

    @Test
    void 게임_진행_횟수_정상_테스트() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    consoleInput(new String[]{"car1, car2", "3"});

                    new GameMachine()
                            .setCarFactory(
                                    new NextStepCarFactory()
                            )
                            .setRacingCarGame(
                                    new RacingCarGame()
                            )
                            .run();

                    assertThat(outputStreamCaptor.toString().contains("car1 : , car2 : - "));
                    assertThat(outputStreamCaptor.toString().contains("car1 : - , car2 : - "));
                    assertThat(outputStreamCaptor.toString().contains("car1 : -- , car2 : - "));
                },
                1,new Integer[]{8, 9, 2, 6, 3}
        );
    }

    @Test
    void 게임_결과_출력_포멧_정상_테스트() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    consoleInput(new String[]{"car1, car2", "1"});

                    new GameMachine()
                            .setCarFactory(
                                    new NextStepCarFactory()
                            )
                            .setRacingCarGame(
                                    new RacingCarGame()
                            )
                            .run();

                    assertThat(outputStreamCaptor.toString().contains("최종 우승자는 car2 입니다."));
                },
                1,new Integer[]{8}
        );
    }

    public void consoleInput(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
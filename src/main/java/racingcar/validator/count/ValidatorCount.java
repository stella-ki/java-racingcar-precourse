package racingcar.validator.count;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.Message;

public class ValidatorCount {
    public int validateCnt() throws IllegalArgumentException{
        int cnt;
        try{
            cnt=  Integer.parseInt(Console.readLine());
            System.out.println(cnt);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_COUNT_WRONG);
        }
        return cnt;
    }
}

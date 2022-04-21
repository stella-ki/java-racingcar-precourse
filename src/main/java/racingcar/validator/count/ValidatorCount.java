package racingcar.validator.count;

import camp.nextstep.edu.missionutils.Console;

public class ValidatorCount {
    public int validateCnt() throws IllegalArgumentException{
        int cnt;
        try{
            cnt=  Integer.parseInt(Console.readLine());
            System.out.println(cnt);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
        return cnt;
    }
}

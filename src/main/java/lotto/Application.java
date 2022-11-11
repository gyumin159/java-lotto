package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    /**
     * 1_000로 나뉘는 올바른 입력인지 확인 후, int로 바꾸어 반환
     * @param gamblerInput 사용자가 입력한 금액
     * @return int로 바꾼 gamblerInput
     */
    public static int stringInputToInt(String gamblerInput){
        checkValidMoneyInput(gamblerInput);
        return Integer.parseInt(gamblerInput);
    }

    /**
     * 입력이 1~9로 시작하여 000으로 끝나는지 확인. 아닐시 IllegalArgumentException 발생
     * @param gamblerInput String 형의 입력값
     */
    public static void checkValidMoneyInput(String gamblerInput){
        boolean isDividedBy1000 = Pattern.matches("^[1-9]+000$", gamblerInput);
        if (!isDividedBy1000) {
            System.out.println("[ERROR] Wrong Input!");
            throw new IllegalArgumentException("[ERROR] Wrong Input!");
        }
    }

//    public static List<Integer> inputWinningNumbers(){
//        String WinningNumbers = Console.readLine();
//
//    }

    /**
     * 숫자와 콤마로만 이루어져 있는지 확인한다.
      * @param winningNumbers 로또 1등 당첨 번호(보너스 번호 제외)
     */
    private static void checkDigitAndComma(String winningNumbers) {
        boolean isRightLottoNumbers = Pattern.matches("^[0-9,]*$", winningNumbers);
        if (!isRightLottoNumbers){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 6개의 숫자가 중복없이 들어왔는지 확인한다.
     * @param winningNumbers 로또 1등 당첨 번호(보너스 번호 제외)
     */
    private static void checkOverlapAndSize(String winningNumbers) {
        List<String> temp = Arrays.asList(winningNumbers.split(","));
        boolean isSizeSix = temp.size() == 6;
        Set<String> delOverlap = new HashSet<>(temp);
        boolean isNoOverlap = delOverlap.size() == 6;
        if (!(isSizeSix && isNoOverlap)){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        String a = Console.readLine();
        int a2 = stringInputToInt(a);
        Gambler p1 = new Gambler(a2);
        p1.buyingLotto();
        p1.printAllLotto();
    }
}

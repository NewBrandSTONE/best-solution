import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RomanNumberTest {

    static List<Integer> inputList = new ArrayList<Integer>();

    @Test
    public void test() {
        System.out.println(romanToInt("IV"));
    }

    public int romanToInt(String text) {
        Integer result;
        char[] chars = text.toCharArray();
        for (char c : chars) {
            inputList.add(getValue(c));
        }
        result = leetCodeCalcResult();
        return result;
    }

    private static int leetCodeCalcResult() {
        int sum = 0;
        if (inputList.isEmpty()) {
            return sum;
        }
        int preNumber = inputList.get(0);
        for (int index = 1; index < inputList.size(); index++) {
            int number = inputList.get(index);
            if (preNumber < number) {
                sum = sum - preNumber;
            } else {
                sum = sum + preNumber;
            }
            preNumber = number;
        }
        // 最后一个直接相加
        sum = sum + preNumber;
        return sum;
    }

    private static Integer getValue(char romaNumber) {
        switch (romaNumber) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return null;
        }
    }


}

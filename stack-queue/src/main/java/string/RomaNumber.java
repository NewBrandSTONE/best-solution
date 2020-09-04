package string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 存在的疑问
 * 1.计算的时候如何知道下一位的值是多少？
 * 第一个值从charAt中获取
 * 后续的值，写一个循环从第二个位置开始获取
 */
public class RomaNumber {

    static HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(outNumber(text));
        scanner.close();
    }

    static Integer outNumber(String text) {
        Integer result = null;
        char[] chars = text.toCharArray();
        for (char c : chars) {
            inputMap.put(c, getValue(c));
        }
        result = calcResult();
        return result;
    }

    private static Integer calcResult() {
        Integer result = null;

        return result;
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
        }
        return null;
    }


}

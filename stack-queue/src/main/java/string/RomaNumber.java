package string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 存在的疑问
 * 1.计算的时候如何知道下一位的值是多少？
 * 第一个值从charAt中获取
 * 后续的值，写一个循环从第二个位置开始获取
 */
public class RomaNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(outNumber(text));
        scanner.close();
    }

    private static Integer outNumber(String text) {
        List<Integer> integerList = new ArrayList<Integer>();
        Integer result;
        char[] chars = text.toCharArray();
        for (char c : chars) {
            integerList.add(getValue(c));
        }
        result = leetCodeCalcResult(integerList);
        return result;
    }

    private static int leetCodeCalcResult(List<Integer> integerList) {
        int sum = 0;
        if (integerList.isEmpty()) {
            return sum;
        }
        int preNumber = integerList.get(0);
        for (int index = 1; index < integerList.size(); index++) {
            int number = integerList.get(index);
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

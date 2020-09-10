package string;

import java.util.*;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 需要考虑a,ab这个特殊用例
 */
public class StringIsResort {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println(CheckPermutation(s1, s2));
//        scanner.close();
        System.out.println(CheckPermutation("jzvthzihsvghjhbrpfhdwixmyaxjrdzfvnhpmyrbqjpdffykqgahgzpjwvouurr", "hhqhxjyrghjjsmduaxppwrqkikqnfdrzjowapehtbyrgrfyprrfrebzduxvvhhu"));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
        setHashMap(m1, s1.toCharArray());
        setHashMap(m2, s2.toCharArray());

        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            Character key = entry.getKey();
            Integer integer = m2.get(key);
            if (integer == null || integer != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static void setHashMap(HashMap<Character, Integer> s1Map, char[] chars1) {
        for (char c : chars1) {
            Integer integer = s1Map.get(c);
            if (integer == null) {
                s1Map.put(c, 1);
            } else {
                int count = integer + 1;
                s1Map.put(c, count);
            }
        }
    }
//
//     if (s2.length() > s1.length()) {
//        // 交换
//        String temp;
//        temp = s1;
//        s1 = s2;
//        s2 = temp;
//    }
//
//    int MismatchTimes = 0;
//    int matchTimes = 0;
//    char[] s1Chars = s1.toCharArray();
//    char[] s2Chars = s2.toCharArray();
//        for (char s1Char : s1Chars) {
//
//        for (char s2Char : s2Chars) {
//            if (s1Char != s2Char) {
//                MismatchTimes++;
//            } else {
//                matchTimes++;
//            }
//        }
//
//        if (MismatchTimes == s2Chars.length) {
//            return false;
//        }
//        MismatchTimes = 0;
//    }

}

package stack;


import java.util.Scanner;

public class ValidateBrackets {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println(validBrackets(text));
        input.close();
    }

    private static boolean validBrackets(String brackets) {
        boolean result = false;
        char[] chars = brackets.toCharArray();
        for (char c : chars) {
            String indexString = Character.toString(c);
        }
        return result;
    }

}

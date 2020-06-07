package _03;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 * 输入描述:
 * 输入数据第一行一个整数N为栈中元素的个数。
 * <p>
 * 接下来一行N个整数X_iX
 * i
 * ​
 * 表示从栈顶依次到栈底的每个元素。
 * 输出描述:
 * 输出一行表示栈中元素逆序后的每个元素
 */
public class Main {

    private static Stack<Integer> myStack = new Stack<Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = Integer.parseInt(scanner.nextLine());
        String numbers = scanner.nextLine();
        if (numbers != null && !"".equals(numbers)) {
            pushStack(numberCount, numbers);
            inverseStack();
        }
    }

    private static void inverseStack() {
        if (myStack.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        inverse();
    }

    private static void inverse() {
        Integer popNumber = myStack.pop();
        System.out.print(popNumber + " ");
        if (!myStack.isEmpty()) {
            inverse();
        }
    }

    private static void pushStack(int numberCount, String numbers) {
        String[] numberArray = numbers.split(" ");
        for (int i = 0; i < numberCount; i++) {
            myStack.push(Integer.parseInt(numberArray[i]));
        }
    }

}

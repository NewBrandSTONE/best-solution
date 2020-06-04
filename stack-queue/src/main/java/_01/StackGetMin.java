package _01;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * 设计一个有 getMin 功能的栈
 * <p>
 * 【题目】
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * <p>
 * 【要求】
 * 1.pop、push、getMin 操作的时间复杂度都是 O(1)。
 * 2.设计的栈类型可以使用现成的栈结构。
 * <p>
 * 【难度】
 * ★☆☆☆
 */
public class StackGetMin {

    public static class MyStack {
        Stack<Integer> normalStack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        int step = scanner.nextInt();
        for (int i = 0; i <= step; i++) {
            String input = scanner.nextLine();
            if (input.startsWith("push")) {
                String[] split = input.split(" ");
                Integer number = Integer.parseInt(split[1]);
                // 入栈
                inStack(myStack, number);
            } else if ("getMin".equals(input)) {
                // 获取最小元素
                System.out.println(getMin(myStack));
            } else if ("pop".equals(input)) {
                // 出栈
                popStack(myStack);
            }
        }
        scanner.close();
    }

    private static void popStack(MyStack myStack) {
        if (myStack.normalStack.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        Integer normalPeek = myStack.normalStack.pop();
        Integer minPeek = myStack.minStack.peek();

        if (normalPeek.intValue() == minPeek.intValue()) {
            myStack.minStack.pop();
        }
    }

    private static Integer getMin(MyStack myStack) {
        if (myStack.minStack.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return myStack.minStack.peek();
    }

    private static void inStack(MyStack myStack, Integer number) {
        myStack.normalStack.push(number);

        if (myStack.minStack.empty()) {
            myStack.minStack.push(number);
        } else {
            Integer minTopValue = myStack.minStack.peek();
            if (number < minTopValue) {
                myStack.minStack.push(number);
            }
        }
    }

}

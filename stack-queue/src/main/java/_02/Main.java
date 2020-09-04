package _02;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 用两个栈实现队列，支持队列的基本操作。
 * 输入描述:
 * 第一行输入一个整数N，表示对队列进行的操作总数。
 * <p>
 * 下面N行每行输入一个字符串S，表示操作的种类。
 * <p>
 * 如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。
 * <p>
 * 如果S为"poll"，则表示弹出队列头部操作。
 * <p>
 * 如果S为"peek"，则表示询问当前队列中头部元素是多少。
 * 输出描述:
 * 对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
 * <p>
 * 解题思路：
 * 1.如果stackPop不为空的时候，stackPush中的数据不能往stackPop中传递
 * 2.@如果stackPush要往stackPop中压入数据，则一次压入必须将所有数据都压入，使用while循环
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TwoStackQueue myStack = new TwoStackQueue();
        int step = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < step; i++) {
            String input = scanner.nextLine();
            // e.g push 3 判断以 push 开头
            if (input.startsWith("add")) {
                // 入栈
                String[] split = input.split(" ");
                Integer number = Integer.parseInt(split[1]);
                myStack.add(number);
            } else if ("peek".equals(input)) {
                // 获取最小元素
                System.out.println(myStack.peek());
            } else if ("poll".equals(input)) {
                // 出栈
                myStack.poll();
            }
        }
        scanner.close();
    }

    public static class TwoStackQueue {
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(Integer addNumber) {
            stackPush.push(addNumber);
            // 只有当stackPop为空的时候才入栈
            pushToPop();
        }

        public void pushToPop() {
            // 多处地方调用这个方法，都是在同一条件下
            // stackPop为空
            // 才会将stackPush中的数据弹到stackPop中
            // 可以考虑将这个判断条件写入到pushToPop中
            // 而不是在调用的时候判断
            if (stackPop.isEmpty()) {
                while (!stackPush.empty()) {
                    Integer popNumber = stackPush.pop();
                    stackPop.push(popNumber);
                }
            }
        }

        public Integer peek() {
            // 查看队列第一个元素，就是stackPop的栈顶元素
            // 将stackPush所有的元素添加到stackPop中
            // 只返回stackPop栈顶上的元素
            // 记得非空判断
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                // 都为空说明没有数据输入
                throw new RuntimeException("your queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }

        public void poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                // 都为空说明没有数据输入
                throw new RuntimeException("your queue is empty");
            }
            pushToPop();
            // stackPop出栈
            stackPop.pop();
        }
    }
}

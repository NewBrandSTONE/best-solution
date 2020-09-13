import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsTest {

    @Test
    public void run() {
//        List<Integer> res = new ArrayList<>();
//        System.out.println(res.get(1));
//        System.out.println(0 < 0);
        Integer temp = 20;
        Integer a = 9;
        Integer b = 2;
        System.out.println((double) (a + temp) / b);
    }

    // 这里还有一个问题
    // List<Double> sums 必须要变成double类型，否则会丢失精度
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        // 保存每一层的节点个数
        List<Integer> counts = new ArrayList<>();
        // 保存每一层的节点只和
        List<Double> sums = new ArrayList<>();

        dfs(root, counts, sums, 0);

        for (int i = 0; i < sums.size(); i++) {
            res.add((sums.get(i) / counts.get(i)));
        }

        // 1.如何构建二叉树
        // 输入[3, 9, 20, 15, 7]
        // 如何转成TreeNode对象？
        // 无需构造二叉树，输入的root里就包含了信息，只需要按照算法进行遍历即可

        // 如何确定二叉树的层级？
        // 深度遍历或者广度遍历
        return res;
    }

    private void dfs(TreeNode node, List<Integer> count, List<Double> sum, int level) {
        if (node == null) {
            return;
        }

        if (level < count.size()) {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            // 添加
            count.add(level, 1);
            sum.add(level, 1.0 * node.val);
        }

        // 如果调用这个会直接报越界异常
//        if (count.get(level) == null) {
//            count.set(level, 1);
//        } else {
//            count.set(level, count.get(level) + 1);
//        }
//
//        if (sum.get(level) == null) {
//            sum.set(level, node.val);
//        } else {
//            sum.set(level, sum.get(level) + node.val);
//        }

        // 先遍历左边
        dfs(node.left, count, sum, level + 1);
        // 再遍历右边
        dfs(node.right, count, sum, level + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

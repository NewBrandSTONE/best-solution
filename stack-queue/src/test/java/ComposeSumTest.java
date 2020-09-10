import org.junit.Test;

import java.util.*;

public class ComposeSumTest {

    @Test
    public void run() {
        int[] arrs = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(arrs, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        // 先对数据进行排序
        Arrays.sort(candidates);
        dfs(candidates, length, 0, target, path, result);
//        dfs(candidates, 0, target, path, result);
        return result;
    }

    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 这里利用了相减的方法
        // 如果减到为0了说明这个path路径上的值正好满足题目的要求
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 大剪枝
            // 说明candidates[i]的值已经大于target
            // 后续还要减的话肯定也是直接小于0
            // 直接跳过这次路径
            if (target - candidates[i] < 0) {
                break;
            }

            // 小减枝
            // 同一层相同数值的节点
            // 从第二个开始
            // 候选数更加少，结果一定发生重复，因此跳过
            // 用continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 记录这个节点
            path.addLast(candidates[i]);
            // 继续递归
            // 因为元素不可复用，这里传递的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            // 移除最后一个
            path.removeLast();
        }
    }

//    private void dfs(int[] candidates, int start, int target, ArrayDeque<Integer> path, List<List<Integer>> result) {
//        if (start == candidates.length) {
//            return;
//        }
//
//        int total = 0;
//        for (Integer record : path) {
//            total += record;
//        }
//        total += candidates[start];
//        if (total < target) {
//            path.add(candidates[start]);
//        }
//        if (total == target) {
//            result.add(new ArrayList<>(path));
//        }
//        // 如何回溯还是没搞懂...
//        // 关键是第一个数组下标移动完成之后，还需要接着下一个走
//        // 10->1开始
//        dfs(candidates, start + 1, target, path, result);
//    }


}

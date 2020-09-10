package _04;

import java.util.*;

/**
 * 组合二
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class ComposeSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        // 先对数据进行排序
        Arrays.sort(candidates);
        dfs(candidates, length, 0, target, path, result);
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
}

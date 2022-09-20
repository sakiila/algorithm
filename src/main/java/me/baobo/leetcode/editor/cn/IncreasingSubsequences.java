//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 426 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491 递增子序列
 * 2022-04-17 12:23:43
 * 思路：回溯
 */
public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backTrace(nums, 0);
            return res;
        }

        private void backTrace(int[] nums, int index) {
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                // 对下一层的节点去重
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                // 当前层 nums[i] 与上一层节点对比
                if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                    continue;
                }
                path.add(nums[i]);
                backTrace(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
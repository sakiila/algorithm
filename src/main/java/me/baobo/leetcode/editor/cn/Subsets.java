//给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 941 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 78 子集
 * 2021-01-11 14:32:55
 * 思路：回溯
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            helper(nums, 0, new ArrayList<>());
            return res;
        }

        void helper(int[] nums, int index, List<Integer> sub) {
            res.add(new ArrayList<>(sub));
            for (int i = index; i < nums.length; i++) {
                sub.add(nums[i]);
                helper(nums, i + 1, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
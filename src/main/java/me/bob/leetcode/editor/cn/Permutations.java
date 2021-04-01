//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1254 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46 全排列
 * 2021-04-01 14:10:47
 * 思路：回溯
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }

            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums.length, output, res, 0);
            return res;
        }

        private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            if (n == first) {
                res.add(new ArrayList<>(output));
            }
            for (int i = first; i < n; i++) {
                Collections.swap(output, i, first);
                backtrack(n, output, res, first + 1);
                Collections.swap(output, i, first);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
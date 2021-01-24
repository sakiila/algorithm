//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 143 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 674 最长连续递增序列
 * 2021-01-24 09:11:05
 * 思路：遍历
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }

            int[] dp = new int[length];
            dp[0] = 1;
            for (int i = 1; i < length; i++) {
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    // 这里不能为0，需要设为1
                    dp[i] = 1;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
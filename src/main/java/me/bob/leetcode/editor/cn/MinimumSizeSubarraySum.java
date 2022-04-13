//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 536 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 209 长度最小的子数组
 * 2021-01-28 08:09:10
 * 思路：滑动窗口
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int i = 0, j = 0, sum = 0, length = Integer.MAX_VALUE;
            
            while (j < nums.length) {
                sum += nums[j];
                while (sum >= s) {
                    length = Math.min(length, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
                j++;
            }

            return length == Integer.MAX_VALUE ? 0 : length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
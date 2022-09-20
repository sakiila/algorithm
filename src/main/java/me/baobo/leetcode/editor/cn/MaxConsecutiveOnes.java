//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 162 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 485 最大连续1的个数
 * 2021-01-28 07:43:42
 * 思路：双指针滑动窗口
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0;
            int i = 0, j = 0;

            while (j < nums.length) {
                // 注意j++
                if (nums[j++] != 1) {
                    res = Math.max(res, j - i - 1);
                    i = j;
                }
            }

            return Math.max(res, j - i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
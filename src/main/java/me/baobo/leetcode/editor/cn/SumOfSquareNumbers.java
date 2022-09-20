//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 180 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 633 平方数之和
 * 2021-04-28 07:15:37
 * 思路：双指针，注意右指针先取平方根
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0, right = (int) Math.sqrt(c);

            while (left <= right) {
                int res = left * left + right * right;
                if (res == c) {
                    return true;
                } else if (res > c) {
                    right--;
                } else if (res < c) {
                    left++;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
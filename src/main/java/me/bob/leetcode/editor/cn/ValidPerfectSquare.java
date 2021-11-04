//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 184 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 367 有效的完全平方数
 * 2021-01-13 18:14:04
 * 思路：二分法
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println("solution.isPerfectSquare() = " + solution.isPerfectSquare(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }

            int left = 1, right = num / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) mid * mid == num) {
                    return true;
                }
                if ((long) mid * mid > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
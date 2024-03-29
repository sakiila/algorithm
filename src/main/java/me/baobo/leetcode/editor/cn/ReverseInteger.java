//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2535 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 7 整数反转
 * 2021-02-19 09:50:11
 * 思路：注意越界情况
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int temp = x;
            if (x < 0) {
                temp = -x;
            }
            long res = 0;

            while (temp > 0) {
                res = res * 10 + temp % 10;
                temp /= 10;
            }

            if (x < 0) {
                res = -res;
            }

            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
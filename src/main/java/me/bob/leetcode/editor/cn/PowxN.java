//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 567 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 50 Pow(x, n)
 * 2021-01-11 11:12:19
 * 思路：快速幂 + 递归
 */
public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n >= 0) {
                return helper(x, n);
            }
            return 1 / helper(x, -n);
        }

        double helper(double x, int n) {
            if (n == 0) {
                return 1.0;
            }
            // 注意 n/2 是 int 类型，1/2 = 0
            double res = helper(x, n / 2);
            return n % 2 == 0 ? res * res : res * res * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
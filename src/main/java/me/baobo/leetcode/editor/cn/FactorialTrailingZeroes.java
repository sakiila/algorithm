//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 427 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 172 阶乘后的零
 * 2021-03-03 09:59:10
 * 思路：数学题
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(10));
        System.out.println(solution.trailingZeroes(12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while (n > 0) {
                n /= 5;
                res += n;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
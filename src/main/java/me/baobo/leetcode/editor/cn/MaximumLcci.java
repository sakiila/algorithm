//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学 
// 👍 75 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 面试题 16.07 最大数值
 * 2021-03-20 09:20:52
 * 思路：根据差值的符号位计算
 * a < b: 1 + (a - b) >> 31 == 0
 * a > b: 1 + (a - b) >> 31 == 1
 */
public class MaximumLcci {
    public static void main(String[] args) {
        Solution solution = new MaximumLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            long i = a, j = b;
            int k = (int) (1 + ((i - j) >> 63));
            return k * a + (k ^ 1) * b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
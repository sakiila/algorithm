//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 570 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 69 x 的平方根
 * 2021-01-13 17:16:55
 * 思路：二分法
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        int i = solution.mySqrt(5);
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }

            int left = 1;
            int right = x;
            int res = 0;
            // 注意大于等于符号
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    res = mid;
                    left = mid + 1;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 141 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 504 七进制数
 * 2022-03-07 11:08:42
 * 思路：除法竖式
 */
public class Base7 {
    public static void main(String[] args) {
//        Solution solution = new Base7().new Solution();

        int num = 100;
        final StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int res = num % 7;
            sb.insert(0, res);
            num /= 7;
        }

        System.out.println("sb = " + sb);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            if (num < 0) {
                return "-" + help(-num);
            }
            return help(num);
        }

        private String help(int num) {
            final StringBuilder sb = new StringBuilder();
            while (num > 0) {
                sb.append(num % 7);
                num /= 7;
            }
            return sb.reverse().toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 915 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 43 字符串相乘
 * 2022-04-30 00:22:13
 * 思路：模拟「竖式乘法」
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            String res = "0";
            if (num1.equals("0") || num2.equals("0")) {
                return res;
            }

            int m = num1.length(), n = num2.length();
            for (int i = n - 1; i >= 0; i--) {
                int y = num2.charAt(i) - '0';

                // 补齐后缀零
                StringBuilder sb = new StringBuilder();
                for (int z = i; z < n - 1; z++) {
                    sb.append('0');
                }

                int carry = 0;
                for (int j = m - 1; j >= 0; j--) {
                    int x = num1.charAt(j) - '0';
                    carry = carry + x * y;
                    sb.append(carry % 10);
                    carry /= 10;
                }
                if (carry != 0) {
                    sb.append(carry);
                }
                res = add(res, sb.reverse().toString());
            }
            return res;
        }

        private String add(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1;
            StringBuilder res = new StringBuilder();
            int carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                carry = carry + x + y;
                res.append(carry % 10);
                carry /= 10;
                i--;
                j--;
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
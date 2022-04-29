//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 555 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 415 字符串相加
 * 2022-04-29 23:44:24
 * 思路：模拟
 */
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int a = num1.length() - 1, b = num2.length() - 1;
            int add = 0;
            StringBuilder res = new StringBuilder();

            while (a >= 0 || b >= 0 || add != 0) {
                int an = a >= 0 ? num1.charAt(a) - '0' : 0;
                int bn = b >= 0 ? num2.charAt(b) - '0' : 0;
                add = add + an + bn;
                res.append(add % 10);
                add /= 10;
                a--;
                b--;
            }

            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
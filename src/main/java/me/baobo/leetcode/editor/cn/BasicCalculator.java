//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 371 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224 基本计算器
 * 2021-03-10 07:40:33
 * 思路：括号展开 + 栈
 */
public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            // 标记正负 1为正， -1为负
            int sign = 1;
            stack.push(sign);

            int res = 0;
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                } else if (c == '+') {
                    sign = stack.peek();
                    i++;
                } else if (c == '-') {
                    sign = -stack.peek();
                    i++;
                } else if (c == '(') {
                    stack.push(sign);
                    i++;
                } else if (c == ')') {
                    stack.pop();
                    i++;
                } else {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    res += num * sign;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
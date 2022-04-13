//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1282 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32 最长有效括号
 * 2021-04-26 20:58:56
 * 思路：栈
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // 最后一个没有被匹配的右括号的下标
                        stack.push(i);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
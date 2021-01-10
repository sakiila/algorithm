//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1506 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 * 2021-01-10 20:45:31
 * 思路：递归
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            helper("", 0, 0, n);
            return res;
        }

        void helper(String str, int left, int right, int n) {
            if (left == n && right == n) {
                res.add(str);
                return;
            }

            if (left < n) {
                helper(str + "(", left + 1, right, n);
            }
            if (left > right) {
                helper(str + ")", left, right + 1, n);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
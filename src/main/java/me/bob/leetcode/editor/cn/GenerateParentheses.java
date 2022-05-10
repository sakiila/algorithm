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
 * 思路：回溯
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println("strings = " + strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        
        public List<String> generateParenthesis(int n) {
            backtracing(n, n, new StringBuilder());
            return res;
        }
        
        private void backtracing(int left, int right, StringBuilder path) {
            if (left > right) {
                return;
            }
            if (left < 0 || right < 0) {
                return;
            }
            if (left == 0 && right == 0) {
                res.add(path.toString());
                return;
            }

            path.append("(");
            backtracing(left - 1, right, path);
            path.deleteCharAt(path.length() - 1);

            path.append(")");
            backtracing(left, right - 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1065 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 17 电话号码的字母组合
 * 2021-01-11 15:28:26
 * 思路：回溯
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return res;
            }

            String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            helper(digits, mapping, 0, res, "");
            return res;
        }

        void helper(String digits, String[] mapping, int depth, List<String> res, String curr) {
            if (depth == digits.length()) {
                res.add(curr);
                return;
            }

            int index = Character.getNumericValue(digits.charAt(depth));
            String s = mapping[index];
            for (int i = 0; i < s.length(); i++) {
                helper(digits, mapping, depth + 1, res, curr + s.charAt(i));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
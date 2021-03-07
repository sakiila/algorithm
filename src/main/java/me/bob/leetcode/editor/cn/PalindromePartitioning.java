//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 530 👎 0


package me.bob.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131 分割回文串
 * 2021-03-07 09:45:26
 * 思路：动态规划 + 回溯
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            int n = s.length();
            List<List<String>> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            char[] c = s.toCharArray();
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (c[j] == c[i] && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                }
            }

            Deque<String> stack = new ArrayDeque<>();
            dfs(s, 0, n, dp, stack, res);
            return res;
        }

        private void dfs(String s, int index, int n, boolean[][] dp, Deque<String> stack, List<List<String>> res) {
            if (index == n) {
                res.add(new ArrayList<>(stack));
                return;
            }

            for (int i = index; i < n; i++) {
                if (dp[index][i]) {
                    stack.addLast(s.substring(index, i + 1));
                    dfs(s, i + 1, n, dp, stack, res);
                    stack.removeLast();
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
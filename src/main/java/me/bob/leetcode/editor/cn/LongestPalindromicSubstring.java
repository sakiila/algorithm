//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3139 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 5 最长回文子串
 * 2021-01-27 09:49:18
 * 思路：dp
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            String res = "";
            // dp 表示以 i 开始，j 结束字符串的回文
            boolean[][] dp = new boolean[n][n];

            // d 是长度
            for (int d = 0; d < n; d++) {
                for (int i = 0; i < n - d; i++) {
                    int j = i + d;
                    if (s.charAt(i) == s.charAt(j)) {
                        if (d == 0 || d == 1) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }

                        if (dp[i][j] && j - i + 1 > res.length()) {
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
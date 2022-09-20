//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 276 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 132 分割回文串 II
 * 2021-03-08 09:30:38
 * 思路：动态规划
 */
public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        solution.minCut("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            if (n < 2) {
                return 0;
            }

            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = i;
            }

            for (int i = 1; i < n; i++) {
                if (check(s, 0, i)) {
                    dp[i] = 0;
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    if (check(s, j + 1, i)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[n - 1];
        }

        private boolean check(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
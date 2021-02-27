//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 309 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 395 至少有 K 个重复字符的最长子串
 * 2021-02-27 10:00:11
 * 思路：分治
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int n = s.length();
            int[] cnt = new int[26];
            // 统计所有的字母出现个数
            for (int c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            // 定义一个字符串，用于传入split函数分割当前字符串
            StringBuilder cut = new StringBuilder();
            cut.append("[");
            // 定义一个标志，用于标记是否所有字符都满足要求
            boolean flag = true;
            // 遍历所有字符
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    // 这个字符不满足要求，并且加入分割串
                    flag = false;
                    cut.append("//");
                    cut.append((char) (i + 'a'));
                }
            }

            // 所有字符都满足要求的话，就直接返回字符串长度
            if (flag) {
                return n;
            }

            cut.append("]");
            // 切割当前字符串，得到被切割的子串数组  [//a//b]
            String[] cuted = s.split(cut.toString());

            int res = 0;
            for (String c : cuted) {
                // 递归处理子串
                res = Math.max(longestSubstring(c, k), res);
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
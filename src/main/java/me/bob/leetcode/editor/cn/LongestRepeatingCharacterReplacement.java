//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 230 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 424 替换后的最长重复字符
 * 2021-02-02 07:13:14
 * 思路：滑动窗口
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] array = s.toCharArray();
            int left = 0, right = 0, res = 0, maxCount = 0;
            int[] freq = new int[26];

            while (right < s.length()) {
                freq[array[right] - 'A']++;
                maxCount = Math.max(maxCount, freq[array[right] - 'A']);
                right++;

                // 窗口长度大于频次与k之和，不满足，则移动左指针
                if (right - left > maxCount + k) {
                    freq[array[left] - 'A']--;
                    left++;
                }

                res = Math.max(res, right - left);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
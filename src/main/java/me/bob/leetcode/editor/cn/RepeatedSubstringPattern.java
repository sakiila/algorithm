//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 674 👎 0


package me.bob.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 459 重复的子字符串
 * 2022-04-15 11:27:07
 * 思路：KMP
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int len = s.length();
            int[] next = new int[len];
            int j = -1;
            next[0] = -1;
            for (int i = 1; i < len; i++) {
                while (j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
                    j = next[j];
                }
                if (s.charAt(j + 1) == s.charAt(i)) {
                    j++;
                }
                next[i] = j;
            }

            System.out.println("Arrays.toString(next) = " + Arrays.toString(next));

            if (next[len - 1] >= 0 && len % (len - (next[len - 1] + 1)) == 0) {
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
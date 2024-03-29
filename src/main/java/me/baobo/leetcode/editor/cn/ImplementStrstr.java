//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 686 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 28 实现 strStr()
 * 2021-01-27 12:08:26
 * 思路：KMP
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }

            int[] next = new int[needle.length()];
            int j = -1;
            next[0] = -1;
            for (int i = 1; i < needle.length(); i++) {
                while (j >= 0 && needle.charAt(j + 1) != needle.charAt(i)) {
                    j = next[j];
                }
                if (needle.charAt(j + 1) == needle.charAt(i)) {
                    j++;
                }
                next[i] = j;
            }
            
            j = -1;
            for (int i = 0; i < haystack.length(); i++) {
                while (j >= 0 && needle.charAt(j + 1) != haystack.charAt(i)) {
                    j = next[j];
                }
                if (needle.charAt(j + 1) == haystack.charAt(i)) {
                    j++;
                }
                if (j == needle.length() - 1) {
                    return i -needle.length() + 1;
                }
            }
            
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
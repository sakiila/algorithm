//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 268 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 557 反转字符串中的单词 III
 * 2021-01-29 17:15:55
 * 思路：双指针
 */
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            char[] chars = s.toCharArray();
            int i = 0, j = 0;
            while (j < chars.length) {
                while (j < chars.length && chars[j] != ' ') {
                    j++;
                }
                for (int k = j - 1; k >= i; k--) {
                    sb.append(chars[k]);
                }
                if (j < chars.length) {
                    sb.append(chars[j++]);
                    i = j;
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 326 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 125 验证回文串
 * 2021-02-13 09:37:51
 * 思路：翻转字符串
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    buffer.append(Character.toLowerCase(ch));
                }
            }
            StringBuffer buffer_rev = new StringBuffer(buffer).reverse();
            return buffer.toString().equals(buffer_rev.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
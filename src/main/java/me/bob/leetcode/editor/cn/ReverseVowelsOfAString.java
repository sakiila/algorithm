//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 140 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 345 反转字符串中的元音字母
 * 2021-02-13 09:48:36
 * 思路：双指针
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] array = s.toCharArray();
            int left = 0, right = array.length - 1;
            while (left < right) {
                while (left < right && !isVowel(array[left])) {
                    left++;
                }
                while (left < right && !isVowel(array[right])) {
                    right--;
                }
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

            return new String(array);
        }

        private boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
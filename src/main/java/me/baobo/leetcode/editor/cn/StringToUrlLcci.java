//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 
// 👍 29 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 面试题 01.03 URL化
 * 2021-03-09 07:26:25
 * 思路：字符数组
 */
public class StringToUrlLcci {
    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            char[] arr = new char[length * 3];
            int index = 0;
            for (int i = 0; i < length; i++) {
                if (S.charAt(i) == ' ') {
                    arr[index++] = '%';
                    arr[index++] = '2';
                    arr[index++] = '0';
                } else {
                    arr[index++] = S.charAt(i);
                }
            }
            return new String(arr, 0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
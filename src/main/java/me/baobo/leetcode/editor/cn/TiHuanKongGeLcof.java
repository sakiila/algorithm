//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 261 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 剑指 Offer 05 替换空格
 * 2022-04-15 08:00:28
 * 思路：双指针
 */
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    str.append("  ");
                }
            }

            if (str.length() == 0) {
                return s;
            }
            
            int left = s.length() - 1;
            s += str.toString();
            int right = s.length() - 1;
            char[] c = s.toCharArray();
            while (left >= 0) {
                if (c[left] == ' ') {
                    c[right--] = '0';
                    c[right--] = '2';
                    c[right--] = '%';
                    left--;
                } else {
                    c[right--] = c[left--];
                }
            }

            return new String(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
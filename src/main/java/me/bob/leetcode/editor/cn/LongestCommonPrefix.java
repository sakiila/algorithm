//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1431 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 14 最长公共前缀
 * 2021-01-27 07:29:51
 * 思路：纵向扫描
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int length = strs[0].length();
            int count = strs.length;

            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 0; j < count; j++) {
                    if (i == strs[j].length() || c != strs[j].charAt(i)) {
                        // substring 左闭右开
                        return strs[0].substring(0, i);
                    }
                }
            }

            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
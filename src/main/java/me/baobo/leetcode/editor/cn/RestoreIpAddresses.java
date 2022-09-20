////有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
////
//// 
//// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312
//" 
////和 "192.168@1.1" 是 无效 IP 地址。 
//// 
////
//// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 
//重新
////排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "25525511135"
////输出：["255.255.11.135","255.255.111.35"]
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "0000"
////输出：["0.0.0.0"]
//// 
////
//// 示例 3： 
////
//// 
////输入：s = "101023"
////输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length <= 20 
//// s 仅由数字组成 
//// 
//// Related Topics 字符串 回溯 👍 910 👎 0
//


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 复原 IP 地址
 * 2022-05-13 10:22:55
 * 思路：回溯
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            backtracking(s, 0, 0);
            return res;
        }

        private void backtracking(String s, int index, int pointNumber) {
            if (pointNumber == 3) {
                if (isValid(s, index, s.length() - 1)) {
                    res.add(s);
                }
            }
            for (int i = index; i < s.length(); i++) {
                if (isValid(s, index, i)) {
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                    backtracking(s, i + 2, pointNumber + 1);
                    s = s.substring(0, i + 1) + s.substring(i + 2);
                } else {
                    break;
                }
            }
        }

        private boolean isValid(String s, int left, int right) {
            if (right - left > 3 || left > right) {
                return false;
            }
            if (s.charAt(left) == '0' && left != right) {
                return false;
            }
            return Integer.parseInt(s.substring(left, right + 1)) <= 255;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
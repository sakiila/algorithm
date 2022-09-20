//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 518 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 179 最大数
 * 2021-04-12 06:33:14
 * 思路：排序
 */
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;

            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

            String res = "";
            for (String s : str) {
                res += s;
            }

            return res.charAt(0) == '0' ? "0" : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
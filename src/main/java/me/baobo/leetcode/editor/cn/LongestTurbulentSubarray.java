//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 84 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 978 最长湍流子数组
 * 2021-02-08 07:40:40
 * 思路：动态规划
 */
public class LongestTurbulentSubarray {
    public static void main(String[] args) {
        Solution solution = new LongestTurbulentSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int len = arr.length;
            if (len < 2) {
                return len;
            }

            int[] increase = new int[len];
            int[] decrease = new int[len];

            increase[0] = 1;
            decrease[0] = 1;

            int res = 1;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] < arr[i]) {
                    increase[i] = decrease[i - 1] + 1;
                    decrease[i] = 1;
                } else if (arr[i - 1] > arr[i]) {
                    decrease[i] = increase[i - 1] + 1;
                    increase[i] = 1;
                } else {
                    increase[i] = 1;
                    decrease[i] = 1;
                }

                res = Math.max(res, Math.max(increase[i], decrease[i]));
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 261 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 556 下一个更大元素 III
 * 2022-07-03 17:56:51
 * 思路：类似下一个排列
 */
public class NextGreaterElementIii {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            char[] arr = String.valueOf(n).toCharArray();

            int len = arr.length;
            int i = len - 2;
            while (i >= 0 && arr[i] >= arr[i + 1]) {
                i--;
            }
            if (i < 0) {
                return -1;
            }

            int j = len - 1;
            while (j >= 0 && arr[i] >= arr[j]) {
                j--;
            }

            // swap
            swap(arr, i, j);

            // reverse
            reverse(arr, i + 1);

            long ans = Long.parseLong(new String(arr));
            return ans > Integer.MAX_VALUE ? -1 : (int) ans;
        }

        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void reverse(char[] arr, int begin) {
            int i = begin, j = arr.length - 1;
            while (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
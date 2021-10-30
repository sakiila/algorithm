//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 数组 👍 466 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 260 只出现一次的数字 III
 * 2021-10-30 09:16:26
 * 思路：Set 集合
 */
public class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                if (!set.add(i)) {
                    set.remove(i);
                }
            }

            int[] res = new int[2];
            int n = 0;
            for (Integer i : set) {
                res[n++] = i;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
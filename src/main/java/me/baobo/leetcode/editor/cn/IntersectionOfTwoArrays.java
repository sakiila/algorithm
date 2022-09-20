//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 321 👎 0


package me.baobo.leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349 两个数组的交集
 * 2021-02-09 09:58:12
 * 思路：哈希集合
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            return Arrays.stream(nums2).distinct().filter(collect::contains).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
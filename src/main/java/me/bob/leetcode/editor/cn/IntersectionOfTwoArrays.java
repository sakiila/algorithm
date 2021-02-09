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


package me.bob.leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 349 两个数组的交集
 * 2021-02-09 09:58:12
 * 思路：哈希表
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
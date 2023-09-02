//给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 
//secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。 
//
// 返回这 两个区间列表的交集 。 
//
// 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。 
//
// 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,
//24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 示例 2： 
//
// 
//输入：firstList = [[1,3],[5,9]], secondList = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：firstList = [], secondList = [[4,8],[10,12]]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：firstList = [[1,7]], secondList = [[3,10]]
//输出：[[3,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 10⁹ 
// endi < starti+1 
// 0 <= startj < endj <= 10⁹ 
// endj < startj+1 
// 
//
// Related Topics 数组 双指针 👍 393 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 986 区间列表的交集
 * 2023-09-02 16:13:53
 * 思路：双指针
 */
public class IntervalListIntersections {

    public static void main(String[] args) {
        Solution solution = new IntervalListIntersections().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            if (firstList.length == 0 || secondList.length == 0) {
                return new int[0][];
            }
            List<Integer[]> list = new ArrayList<>();
            int i = 0, j = 0;
            while (i < firstList.length && j < secondList.length) {
                int firstLeft = firstList[i][0];
                int firstRight = firstList[i][1];
                int secondLeft = secondList[j][0];
                int secondRight = secondList[j][1];
                if (firstLeft <= secondRight && secondLeft <= firstRight) {
                    list.add(new Integer[]{Math.max(firstLeft, secondLeft), Math.min(firstRight, secondRight)});
                }
                if (secondRight < firstRight) {
                    j++;
                } else {
                    i++;
                }
            }
//            for (int i = 0; i < firstList.length; i++) {
//                for (int j = 0; j < secondList.length; j++) {
//                    int firstLeft = firstList[i][0];
//                    int firstRight = firstList[i][1];
//                    int secondLeft = secondList[j][0];
//                    int secondRight = secondList[j][1];
//                    if (firstLeft <= secondRight && secondRight <= firstRight) {
//                        list.add(new Integer[]{Math.max(firstLeft, secondLeft), secondRight});
//                    } else if (firstLeft <= secondLeft && secondLeft <= firstRight) {
//                        list.add(new Integer[]{secondLeft, Math.min(firstRight, secondRight)});
//                    } else if (secondLeft <= firstLeft && firstRight <= secondRight) {
//                        list.add(new Integer[]{firstLeft, firstRight});
//                    }
//                }
//            }

            int[][] res = new int[list.size()][];
            for (int k = 0; k < list.size(); k++) {
                res[k] = new int[2];
                res[k][0] = list.get(k)[0];
                res[k][1] = list.get(k)[1];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
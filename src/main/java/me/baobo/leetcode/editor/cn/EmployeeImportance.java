//给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。 
//
// 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15,
// [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但
//是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。 
//
// 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。 
//
// 
//
// 示例： 
//
// 
//输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//输出：11
//解释：
//员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 1
//1 。
// 
//
// 
//
// 提示： 
//
// 
// 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属 
// 员工数量不超过 2000 。 
// 
// Related Topics 深度优先搜索 广度优先搜索 哈希表 
// 👍 146 👎 0


package me.baobo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690 员工的重要性
 * 2021-05-01 08:22:59
 * 思路：BFS，使用队列
 */
public class EmployeeImportance {
    public static void main(String[] args) {
        Solution solution = new EmployeeImportance().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

    class Solution {

        public int getImportance(List<Employee> employees, int id) {
            // 先保存员工对应关系
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee employee : employees) {
                map.put(employee.id, employee);
            }

            // 使用队列循环遍历
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(id);

            int res = 0;
            while (!queue.isEmpty()) {
                int curId = queue.poll();
                Employee employee = map.get(curId);
                res += employee.importance;
                for (int subId : employee.subordinates) {
                    queue.offer(subId);
                }
            }

            return res;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
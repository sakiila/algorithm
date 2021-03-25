//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 497 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 82 删除排序链表中的重复元素 II
 * 2021-03-25 07:55:36
 * 思路：一次遍历即可
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(0, head);
            ListNode temp = dummy;
            while (temp.next != null && temp.next.next != null) {
                if (temp.next.val == temp.next.next.val) {
                    // 保存临时值
                    int x = temp.next.val;
                    while (temp.next != null && temp.next.val == x) {
                        temp.next = temp.next.next;
                    }
                } else {
                    temp = temp.next;
                }
            }
            return dummy.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
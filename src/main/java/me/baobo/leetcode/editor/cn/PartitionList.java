// 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,4,3,2,5,2], x = 3
// 输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
// 输入：head = [2,1], x = 2
// 输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 807 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 86 分隔链表
 * 2024-01-14 09:59:41
 * 思路：三指针
 */
public class PartitionList {

    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
    }

// leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            ListNode node = dummy;
            while (curr != null) {
                if (curr.val < x) {
                    // prev 指向 curr 后一个
                    prev.next = curr.next;
                    // curr 指向 node 后一个
                    curr.next = node.next;
                    // node 指向 curr
                    node.next = curr;

                    node = node.next;
                    prev = curr; // 注意这里，需要将 prev 指回 curr，不能不变，否则不能向前移动
                    curr = prev.next;
                } else {
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
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
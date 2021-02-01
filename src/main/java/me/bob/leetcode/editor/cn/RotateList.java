//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 407 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 61 旋转链表
 * 2021-02-01 11:09:39
 * 思路：成环，新头结点是n - k % n
 */
public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }

            // 计算结点数
            ListNode old_tail = head;
            int n;
            for (n = 1; old_tail.next != null; n++) {
                old_tail = old_tail.next;
            }

            // 成环
            old_tail.next = head;

            ListNode new_tail = head;
            for (int i = 0; i < n - k % n - 1; i++) {
                new_tail = new_tail.next;
            }
            ListNode new_head = new_tail.next;
            new_tail.next = null;

            return new_head;
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
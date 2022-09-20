//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 721 👎 0


package me.baobo.leetcode.editor.cn;

/**
 * 92 反转链表 II
 * 2021-03-18 07:41:15
 * 思路：使用三个指针变量 pre、curr、next，每次翻转两个
 */
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }

            ListNode curr = pre.next;
            for (int i = left; i < right; i++) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = pre.next; // 注意这里
                pre.next = temp;
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
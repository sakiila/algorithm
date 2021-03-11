//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1036 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 148 排序链表
 * 2021-03-11 08:40:35
 * 思路：归并排序
 */
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow;
            ListNode a = sortList(head, mid);
            ListNode b = sortList(mid, tail);
            return merge(a, b);
        }

        private ListNode merge(ListNode a, ListNode b) {
            ListNode dummy = new ListNode();
            ListNode temp = dummy;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    temp.next = a;
                    a = a.next;
                } else {
                    temp.next = b;
                    b = b.next;
                }
                temp = temp.next;
            }
            temp.next = a == null ? b : a;
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
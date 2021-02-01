//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表 
// 👍 477 👎 0


package me.bob.leetcode.editor.cn;

/**
 * 138 复制带随机指针的链表
 * 2021-02-01 09:51:16
 * 思路：将每个拷贝节点都放在原来对应节点的旁边
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }

            // Creating a new weaved list of original and copied nodes.
            Node temp = head;
            while (temp != null) {

                // Cloned node
                Node newNode = new Node(temp.val);

                // Inserting the cloned node just next to the original node.
                // If A->B->C is the original linked list,
                // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
                newNode.next = temp.next;
                temp.next = newNode;
                temp = newNode.next;
            }

            temp = head;

            // Now link the random pointers of the new nodes created.
            // Iterate the newly created list and use the original nodes' random pointers,
            // to assign references to random pointers for cloned nodes.
            while (temp != null) {
                temp.next.random = (temp.random != null) ? temp.random.next : null;
                temp = temp.next.next;
            }

            // Unweave the linked list to get back the original linked list and the cloned list.
            // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
            Node ptr_old_list = head; // A->B->C
            Node ptr_new_list = head.next; // A'->B'->C'
            Node head_old = head.next;
            while (ptr_old_list != null) {
                ptr_old_list.next = ptr_old_list.next.next;
                ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
                ptr_old_list = ptr_old_list.next;
                ptr_new_list = ptr_new_list.next;
            }
            return head_old;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
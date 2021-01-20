//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1106 👎 0


package me.bob.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 146 LRU 缓存机制
 * 2021-01-20 14:04:34
 * 思路：哈希表 + 双向链表
 */
public class LruCache {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class Node {
            public int key, value;
            public Node next, prev;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        class DoubleList {
            public Node head = new Node(0, 0);
            public Node tail = new Node(0, 0);
            public int size;

            public DoubleList() {
                head.next = tail;
                tail.next = head;
                size = 0;
            }

            public void addFirst(Node n) {
                Node headNext = head.next;
                head.next = n;
                headNext.prev = n;
                n.prev = head;
                n.next = headNext;
                size++;
            }

            public void remove(Node n) {
                n.prev.next = n.next;
                n.next.prev = n.prev;
                size--;
            }

            public Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }

            public int size() {
                return size;
            }
        }


        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            cache = new DoubleList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).value;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node n = new Node(key, value);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(n);
                map.put(key, n);
            } else {
                if (cache.size() == capacity) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(n);
                map.put(key, n);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
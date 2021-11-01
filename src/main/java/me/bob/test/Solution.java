package me.bob.test;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        Solution sol = new Solution();
        int[] lru = sol.LRU(operators, 3);
        System.out.println(Arrays.toString(lru));
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int size;
    private Node head;
    private Node tail;

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        map = new HashMap<>();
        size = k;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                int value = get(operators[i][1]);
                list.add(value);
            }
        }

        System.out.println(list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            // move to head
            moveToHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            // add to head
            addToHead(node);
            if (map.size() > size) {
                // remove tail
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            // move to head
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


}
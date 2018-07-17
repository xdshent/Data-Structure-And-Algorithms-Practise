package com.github.xdshent.algorithm.array;

/**
 * Remove Nth node from end of list
 * Given a linked list, remove the n-th node from the end of list and return head.
 * Example:
 * Given linked list: 1->2->3->4->5 and n=2
 * After removing the second node from the end, the linked list becomes 1->2->3->5
 * <p>
 * Note:
 * Given n will always valid.
 */
public class RemoveNThNode {

    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param listNode
     * @param n
     * @return
     */
    public static ListNode removeNthNode1(ListNode listNode, int n) {
        if (listNode == null || n <= 0) {
            return null;
        }

        int len = 0;

        ListNode cursor = listNode;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }

        if (n > len) {
            return null;
        }

        cursor = listNode;
        for (int i = 1; i < len - n; i++) {
            cursor = cursor.next;
        }

        cursor.next = cursor.next.next;
        return listNode;
    }

    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param listNode
     * @param n
     */
    public static ListNode removeNthNode2(ListNode listNode, int n) {
        if (listNode == null || n <= 0) {
            return null;
        }

        ListNode fastIndex = listNode;
        ListNode slowIndex = listNode;

        while (n > 0) {
            fastIndex = fastIndex.next;
            if (fastIndex == null) {
                return null;
            }
            n--;
        }

        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        ListNode removeIndex = slowIndex.next;
        slowIndex.next = removeIndex.next;
        return listNode;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

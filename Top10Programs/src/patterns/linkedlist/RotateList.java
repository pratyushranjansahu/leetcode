package patterns.linkedlist;
/*
    https://leetcode.com/problems/rotate-list/
    https://www.youtube.com/watch?v=QxevnZTKvXc
 */
public class RotateList {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        head = rotateRight(head,2);
        while (head != null) {
            System.out.print(head.val+" ");//4 5 1 2 3
            head = head.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        ListNode prev = tmp;
        while (tmp != null) {
            len += 1;
            tmp = tmp.next;
        }
        if (k != 0 && len != 0) {
            k = k % len;
        }
        if (k == 0 || len == 0) {
            return head;
        }
        k = len - k;
        tmp = head;
        for (int i = 1; i <= k; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        ListNode start = tmp;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        prev.next = null;
        return start;
    }
}

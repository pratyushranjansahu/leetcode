package patterns.linkedlist;
/*
    https://leetcode.com/problems/reverse-nodes-in-k-group/
    https://www.youtube.com/watch?v=EKgNMFCShO8&t=1070s
 */
public class ReverseNodesInKGroup {
    public static class ListNode {
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
        int k = 3;

        head = reverseKGroup(head,k);
        while (head != null) {
            System.out.print(head.val+" ");//3 2 1 4 5
            head = head.next;
        }
    }
    static ListNode th = null;
    static ListNode tt = null;

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode oh = null, ot = null;
        int len = size(head);
        ListNode curr = head;
        while (len >= k) {
            int temp = k;
            while (temp-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }

    private static void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    private static int size(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}

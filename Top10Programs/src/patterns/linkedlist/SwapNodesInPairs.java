package patterns.linkedlist;
/*
    https://leetcode.com/problems/swap-nodes-in-pairs/
    https://www.youtube.com/watch?v=-xwX521Ija4
 */
public class SwapNodesInPairs {
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
        head = swapPairs(head);
        while (head != null) {
            System.out.print(head.val+" ");//2 1 4 3 5
            head = head.next;
        }

    }
    public static ListNode swapPairs(ListNode head) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode curr = tmp;
        while(curr.next != null && curr.next.next != null) {
            ListNode firstNode = curr.next;
            ListNode secondNode = curr.next.next;
            firstNode.next = secondNode.next;
            curr.next = secondNode;
            curr.next.next = firstNode;
            curr = curr.next.next;
        }
        return tmp.next;
    }
}

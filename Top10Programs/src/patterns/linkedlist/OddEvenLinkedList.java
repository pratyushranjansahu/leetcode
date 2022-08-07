package patterns.linkedlist;

/*
    https://leetcode.com/problems/odd-even-linked-list/
    https://www.youtube.com/watch?v=1FJHhl22S7c
 */
public class OddEvenLinkedList {
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
        head = oddEvenList(head);
        while (head != null) {
            System.out.print(head.val+" ");//1 3 5 2 4
            head = head.next;
        }
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddIt = head;
        ListNode evenIt = head.next;
        ListNode evenHead = evenIt;

        while (oddIt.next != null && evenIt.next != null) {
            ListNode oddNext = evenIt.next;
            oddIt.next = oddNext;
            oddIt = oddIt.next;
            if (oddIt != null) {
                evenIt.next = oddIt.next;
                evenIt = evenIt.next;
            }
        }
        oddIt.next = evenHead;
        return head;
    }
}

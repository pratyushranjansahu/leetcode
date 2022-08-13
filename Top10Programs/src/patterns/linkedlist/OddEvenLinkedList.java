package patterns.linkedlist;

/*
    https://leetcode.com/problems/odd-even-linked-list/
    https://www.youtube.com/watch?v=C_LA6SOwVTM
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
        if (head == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

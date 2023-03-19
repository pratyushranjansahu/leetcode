package patterns.linkedlist;
/*
    https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycleII {
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

        fifth.next = third;
        ListNode lNode = hasCycle(head);
        System.out.println(lNode.val);//3
    }
    public static ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;

        }

        if(fast == null || fast.next == null)
            return null;

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}

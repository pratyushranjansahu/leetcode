package patterns.linkedlist;
/*
    https://leetcode.com/problems/reverse-linked-list-ii/
    https://www.youtube.com/watch?v=GSJuwQzKSnI
 */
public class ReverseLinkedListII {
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
        head = reverseBetween(head, 2, 4);
        while (head != null) {
            System.out.print(head.val+" ");//1 4 3 2 5
            head = head.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;

        ListNode cur = head, prev=null;
        while(left > 1)
        {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode start = prev, tail=cur;
        ListNode temp = null;
        while(right > 0)
        {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            right--;
        }

        if(start != null){
            start.next = prev;
        }
        else
        {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}

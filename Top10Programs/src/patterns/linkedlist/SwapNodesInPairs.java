package patterns.linkedlist;
/*
    https://leetcode.com/problems/swap-nodes-in-pairs/
    https://www.youtube.com/watch?v=2-fFzM4wtlI&list=PLEI-q7w3s9gQIB_urBmMV04f_NBelXJEP&index=17
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
        if(head == null ||head.next == null ){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        ListNode it = first;
        ListNode previt = null;
        ListNode newHead = null;
        while(it!=null && it.next!=null){

            first = it;
            second = it.next;
            if(previt!=null){
                previt.next = second;
            }
            if(newHead == null){
                newHead = second;
            }
            if(it.next!=null) {
                it = it.next.next;
            }
            second.next = first;
            first.next = it;
            previt = first;

        }
        return newHead;
    }
}

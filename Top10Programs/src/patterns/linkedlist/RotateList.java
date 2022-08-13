package patterns.linkedlist;
/*
    https://leetcode.com/problems/rotate-list/
    https://www.youtube.com/watch?v=CttdbiOArGg
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
        if(head == null)
            return head;
        int n = size(head);
        int loop = k % n;
        loop = n - loop;
        if(n == 1 || loop == n){
            return head;
        }
        int  j = 0;
        ListNode tmp = head;
        ListNode firstAdd = head;
        while(tmp != null) {
            j++;
            if(j == loop) {
                firstAdd = tmp.next;
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
        }
        tmp = firstAdd;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        return firstAdd;
    }
    private static int size(ListNode head) {
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}

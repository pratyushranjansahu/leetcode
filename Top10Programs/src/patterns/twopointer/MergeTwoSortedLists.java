package patterns.twopointer;
/*
    https://leetcode.com/problems/merge-two-sorted-lists/
    https://www.youtube.com/watch?v=g_uxlc8C6HE&t=41s
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1_a = new ListNode(1);
        ListNode l1_b = new ListNode(2);
        ListNode l1_c = new ListNode(4);
        l1_a.next = l1_b;
        l1_b.next = l1_c;

        ListNode l2_a = new ListNode(1);
        ListNode l2_b = new ListNode(3);
        ListNode l2_c = new ListNode(4);
        l2_a.next = l2_b;
        l2_b.next = l2_c;
        ListNode node = mergeTwoLists(l1_a,l2_a);
        while (node != null){
            System.out.print(node.val+" ");//1 1 2 3 4 4
            node = node.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            //Merge List
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1=l1.next;
            }
            else{
                curr.next = l2;
                l2=l2.next;
            }
            curr= curr.next;
        }
        curr.next= l1!=null ? l1 : l2;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

package patterns.heaps;

import java.util.PriorityQueue;
import java.util.Queue;
/*
    https://leetcode.com/problems/merge-k-sorted-lists/
    https://www.youtube.com/watch?v=u8LQt_iUKps
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1_a = new ListNode(1);
        ListNode l1_b = new ListNode(4);
        ListNode l1_c = new ListNode(5);
        l1_a.next = l1_b;
        l1_b.next = l1_c;

        ListNode l2_a = new ListNode(2);
        ListNode l2_b = new ListNode(3);
        l2_a.next = l2_b;

        ListNode[] arr = new ListNode[2];
        arr[0] = l1_a;
        arr[1] = l2_a;
        ListNode l = mergeKLists(arr);
        while (l != null){
            System.out.println("data is : "+l.val);// 1 -> 2 -> 3 -> 4 -> 5
            l = l.next;
        }


    }
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        // only head pointer of all lists are added
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            if(point.next!=null){
                q.add(point.next); // add next of current smallest
            }
        }
        return head.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

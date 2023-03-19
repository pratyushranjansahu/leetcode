package patterns.linkedlist;

/*
    https://leetcode.com/problems/intersection-of-two-linked-lists/description/
    https://blog.devgenius.io/leetcode-160-intersection-of-two-linked-lists-solution-with-images-e7e2508f358e
 */
public class IntersectionOfTwoLinkedLists {
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

        ListNode  head1 = second;
        head1.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode l1 = getIntersectionNode(head,head1);
        System.out.println(l1.val);//2

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA!=nodeB){

            if(nodeA!=null){
                nodeA = nodeA.next;
            }else{
                nodeA = headB;
            }

            if(nodeB!=null){
                nodeB = nodeB.next;
            }else{
                nodeB = headA;
            }
        }
        return nodeA;
    }
}

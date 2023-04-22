package patterns.binarytree;

import java.util.*;
/*
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    https://www.youtube.com/watch?v=_IHzJ15kMMM
 */
public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));//
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        // base case
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;
        int l = 0;
        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                curr = queue.poll();
                if(l % 2 == 0) {
                    subList.add(curr.val);
                }else {
                    stack.add(curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            l++;
            if(!stack.isEmpty()){
                while (!stack.isEmpty())
                    subList.add(stack.pop());
                res.add(subList);
            }else {
                res.add(subList);
            }

        }
        return res;
    }
}

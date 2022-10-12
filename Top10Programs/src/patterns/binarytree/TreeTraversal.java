package patterns.binarytree;

import java.util.*;

//https://www.techiedelight.com/postorder-tree-traversal-iterative-recursive/
//https://www.youtube.com/watch?v=f-zmIvul-CA
public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        preOrderTraversal(root);
        inOrderTraversal(root);
        postOrderTraversal(root);
        levelOrderTraversal(root);

        reverseLevelOrderTraversal(root);

    }

    private static void preOrderTraversal(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    private static void inOrderTraversal(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null)
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    private static void postOrderTraversal(TreeNode root){
        if(root == null)
            return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.peek();
            if (current.isLeaf()){
                TreeNode node = stack.pop();
                System.out.println(node.val);
            }else {
                if (current.right != null){
                    stack.push(current.right);
                    current.right = null;
                }
                if (current.left != null){
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }
    }
    public static List<List<Integer>> levelOrderTraversal(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList();
        // base case
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;

        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i = 0; i < n; i++){
                curr = queue.poll();
                System.out.print(curr.val + " ");
                subList.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(subList);
        }
        return res;
    }

    public static List<List<Integer>>  reverseLevelOrderTraversal(TreeNode root)
    {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            res.add(0,subList);

        }
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root == p || root == q)
            return root;

        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right =  lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}

package patterns.binarytree;

import java.util.Stack;
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

}

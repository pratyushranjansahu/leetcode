package patterns.binarytree;

/*
    https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
    https://thecodingsimplified.com/print-boundary-nodes-in-binary-tree/
 */
import java.util.ArrayList;

public class BoundaryViewTraversal {

    ArrayList <Integer> res = new ArrayList<Integer>();
    ArrayList<Integer> boundary(TreeNode node)
    {
        if(node != null){
            res.add(node.val);
            printBoundaryLeft(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printBoundaryRight(node.right);
        }

        return res;
    }

    public void printBoundaryLeft(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            res.add(node.val);
            // System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            res.add(node.val);
            // System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }

    public void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }

        printLeaves(node.left);

        if (node.left == null && node.right == null) {
            res.add(node.val);
            //System.out.print(node.data + " ");
        }
        printLeaves(node.right);
    }

    public void printBoundaryRight(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printBoundaryRight(node.right);
            res.add(node.val);
            // System.out.print(node.data + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            res.add(node.val);
            // System.out.print(node.data + " ");
        }
    }
}

package patterns.binarytree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));//4
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int lHeight = TreeNode.maxDepth(root.left);
        int rHeight = TreeNode.maxDepth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);

        int dia = Math.max(lHeight+rHeight+1, Math.max(ldia,rdia));
        return dia;

    }
}

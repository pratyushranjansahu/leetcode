package patterns.binarytree;

public class TreeComparison {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = root;
        TreeNode q = root;
        System.out.println("isSame Tree : "+isSameTree(p,q));
        System.out.println("************************");

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println("isSymmetric Tree : "+isSymmetric(root));
        System.out.println("************************");

        
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }

        if (p.val == q.val){
            if (isSameTree(p.left,q.left) && isSameTree(p.right,q.right))
                return true;
        }
        return false;
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (node1.val != node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}

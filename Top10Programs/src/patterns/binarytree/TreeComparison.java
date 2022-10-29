package patterns.binarytree;

public class TreeComparison {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = root;
        TreeNode q = root;
        System.out.println("isSame Tree : "+isSameTree(p,q));
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
}

package patterns.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
    https://practice.geeksforgeeks.org/problems/burning-tree/1
    https://github.com/striver79/FreeKaTreeSeries/blob/main/L31_timeToBurnATreeJava
    https://www.youtube.com/watch?v=2r5wLmQfD6g&t=983s
 */
public class BurningTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(10);

        int target = 8;
        System.out.println(minTime(root,target));//7

    }

    public static int minTime(TreeNode root, int target)
    {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode start = bfsToMapParents(root, mpp, target);
        int maxi = findMaxDistance(mpp, start);
        return maxi;
    }

    private  static TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> mpp, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    private static int findMaxDistance(HashMap<TreeNode, TreeNode> mpp, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        vis.put(target, true);
        int maxi = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;

            for(int i = 0;i<sz;i++) {
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, true);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, true);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), true);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
}

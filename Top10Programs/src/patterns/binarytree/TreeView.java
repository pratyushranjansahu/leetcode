package patterns.binarytree;

import java.util.*;

/*

    https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class TreeView {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);*/

       // System.out.println(leftView(root));
        //System.out.println(rightSideView(root));

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        root.right.left.right.right = new TreeNode(11);
        root.right.left.right.right.right = new TreeNode(12);*/

       // System.out.println(topView(root));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(verticalOrder(root));



    }

    private static List<Integer> leftView(TreeNode root) {
        System.out.println("Left View");
        List<Integer> res = new ArrayList();
        // base case
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;

        while (!queue.isEmpty()) {

            int n = queue.size();
            for(int i = 0; i < n; i++){
                curr = queue.poll();
                if(i == 0)
                    res.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }

    private static List<Integer> rightSideView(TreeNode root) {
        System.out.println("Right View");
        List<Integer> res = new ArrayList();
        // base case
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;

        while (!queue.isEmpty()) {

            int n = queue.size();
            for(int i = 0; i < n; i++){
                curr = queue.poll();
                if(i == n-1)
                    res.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }

    private static ArrayList<Integer> topView(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            int l = level.poll();
            minLevel = Math.min(minLevel,l);
            maxLevel = Math.max(maxLevel,l);

            if (map.containsKey(l)){
                map.get(l).add(p.val);
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(p.val);
                map.put(l,tmp);
            }

            if (p.left != null){
                queue.offer(p.left);
                level.offer(l-1);
            }
            if (p.right != null){
                queue.offer(p.right);
                level.offer(l+1);
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            if (map.containsKey(i)){
                res.add(map.get(i).get(0));
            }
        }
        return res;
    }

    public ArrayList <Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            int l = level.poll();
            minLevel = Math.min(minLevel,l);
            maxLevel = Math.max(maxLevel,l);

            if (map.containsKey(l)){
                map.get(l).add(p.val);
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(p.val);
                map.put(l,tmp);
            }

            if (p.left != null){
                queue.offer(p.left);
                level.offer(l-1);
            }
            if (p.right != null){
                queue.offer(p.right);
                level.offer(l+1);
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            if (map.containsKey(i)){
                List<Integer> list = map.get(i);
                res.add(list.get(list.size() - 1));
            }
        }
        return res;
    }

    private  static ArrayList <Integer> verticalOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList <Integer> retValue = new ArrayList();
        if (root == null)
            return retValue;

        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            int l = level.poll();
            minLevel = Math.min(minLevel,l);
            maxLevel = Math.max(maxLevel,l);

            if (map.containsKey(l)){
                map.get(l).add(p.val);
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(p.val);
                map.put(l,tmp);
            }

            if (p.left != null){
                queue.offer(p.left);
                level.offer(l-1);
            }
            if (p.right != null){
                queue.offer(p.right);
                level.offer(l+1);
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            if (map.containsKey(i)){
                res.add(map.get(i));
            }
        }
        for(List<Integer> list : res){
            for(int i = 0; i< list.size();i++){
                retValue.add(list.get(i));
            }

        }
        return retValue;
    }

}

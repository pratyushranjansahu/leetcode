package patterns.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    https://www.youtube.com/watch?v=WlZ7d4ZfQYw
 */
public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        String s = serialize(root);
        System.out.println("After serialization : "+s);
        System.out.println(deserialize(s));
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return preOrder(list);
    }
    public static void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        }else {
            sb.append(root.val+",");
            preOrder(root.left,sb);
            preOrder(root.right,sb);
        }
    }
    public static TreeNode preOrder(List<String> list) {
        String s = list.get(0);
        if (s.equals("null")) {
            list.remove(0);
            return null;
        }else {
            int num = Integer.parseInt(s);
            TreeNode root = new TreeNode(num);
            list.remove(0);
            root.left = preOrder(list);
            root.right = preOrder(list);
            return root;
        }
    }
}

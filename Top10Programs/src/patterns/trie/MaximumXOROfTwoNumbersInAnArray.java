package patterns.trie;
/*
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * https://www.youtube.com/watch?v=OUNfpFswJq8
 */
public class MaximumXOROfTwoNumbersInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));//28
    }
    static class Trie {
         Trie left, right;

        public void insert (int val){
            Trie curr = this;
            int bitIndex = 30;
            while (bitIndex >= 0) {
                int mask = 1 << bitIndex;
                int bit = (mask&val)  > 0 ? 1 : 0;
                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new Trie();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Trie();
                    }
                    curr = curr.right;
                }
                bitIndex--;
            }
        }
        public int query(int find) {
            int ans = 0;
            int bitIndex = 30;
            Trie curr = this;
            while (bitIndex >= 0) {
                int mask = 1 << bitIndex;
                int bit = (mask&find)  > 0 ? 1 : 0;
                if (bit == 0) {
                    if (curr.left != null) {
                        curr = curr.left;
                    }else {
                        curr = curr.right;
                        ans |= mask;
                    }
                }else {
                    if (curr.right != null) {
                        curr = curr.right;
                        ans |= mask;
                    }else {
                        curr = curr.left;
                    }
                }
                bitIndex--;
            }
            return ans;
        }
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }
        int max = 0;
        for (int v : nums) {
            int find = Integer.MAX_VALUE ^ v;
            int res = trie.query(find);
            max = Math.max(max, res ^ v);
        }
        return max;
    }
}

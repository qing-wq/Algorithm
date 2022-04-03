package LeetCode.二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 最小高度树 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums,0,nums.length);
        }

        private TreeNode dfs(int[] nums, int left, int right) {
            if (left >= right) {
                return null;
            }
            int mid = left+right >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid);
            root.right = dfs(nums,mid+1,right);
            return root;
        }
    }
}

package LeetCode.二叉树;

public class 将有序数组转换为二叉搜索树 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums, 0, nums.length);
        }

        private TreeNode dfs(int[] nums, int left, int right) {
            if (left >= right) {
                return null;
            }
            int mid = left + right >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid);
            root.right = dfs(nums, mid + 1, right);
            return root;
        }
    }
}

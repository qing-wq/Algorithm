package LeetCode;

public class 二叉树的最大深度 {
    int maxLen;
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            maxLen = Integer.MIN_VALUE;
            dfs(root,0);
            return maxLen;
        }

        private void dfs(TreeNode root,int len) {
            if (root == null) {
                if (len > maxLen) {
                    maxLen = len;
                }
                return;
            }
            len++;
            dfs(root.left,len);
            dfs(root.right,len);
        }
    }
}

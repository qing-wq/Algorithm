package LeetCode;

public class 平衡二叉树 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        // 用于计算每棵树的高度
        private int dfs(TreeNode root) {
            // 边界条件
            if (root == null) {
                return 0;
            }
            // 每棵树的高度为左右子树的最大值+本身的高度1
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }

    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            System.out.println(dfs(root));
            return dfs(root) >=0;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 如果不是平衡二叉树，返回-1
            int l = dfs(root.left);
            int r = dfs(root.right);
            if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
                return -1;
            }else {
                // 是平衡二叉树返回高度
                return Math.max(l,r)+1;
            }
        }
    }
}

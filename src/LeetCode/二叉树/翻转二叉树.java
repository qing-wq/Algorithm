package LeetCode.二叉树;

import LeetCode.二叉树.TreeNode;

public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new Solution().invertTree(new TreeNode(1, new TreeNode(2, null, null), null));
        System.out.println(root);
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
//            reverse(root.left, root.right);
//            return root;
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }

        private void reverse(TreeNode left, TreeNode right) {
            if(left == null && right == null) return;

            reverse(left.left,right.right);
            reverse(left.right,right.left);

            int temp;
            if (left == null) {
                right = null;
            }
            if (right == null) {
                left = null;
            }else {
                temp = left.val;
                left.val = right.val;
                right.val = temp;

            }

//            temp = left.right.val;
//            left.right.val = right.left.val;
//            right.left.val = temp;
        }
    }
}

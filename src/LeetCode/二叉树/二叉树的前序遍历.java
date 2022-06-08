package LeetCode.二叉树;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        new Solution2().preorderTraversal(new TreeNode(1,null,new TreeNode(2,null,new TreeNode(3,null,null))));
    }
// 前序遍历:根 左 右
    // 递归
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            Iter(root);
            return list;
        }

        private void Iter(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            Iter(root.left);
            Iter(root.right);
        }
    }

    // 迭代算法
    static class Solution2 {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            while (root != null || !stack.isEmpty()) {
                // 沿左子树一直遍历，一直到null
                while (root != null) {
                    list.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return list;
        }
    }
}

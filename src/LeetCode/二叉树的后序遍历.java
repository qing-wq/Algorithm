package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 后序遍历：左 右 根
public class 二叉树的后序遍历 {
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            Iter(root);
            return list;
        }

        private void Iter(TreeNode root) {
            if (root == null) {
                return;
            }
            Iter(root.left);
            Iter(root.right);
            list.add(root.val);
        }
    }

    class Solution2 {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
//                root = root.right;
//                list.add(root.val);
                if (root.right == null || pre == root.right) {
                    // 右子树不存在或已经被访问
                    list.add(root.val);
                    pre = root;
                    root = null;
                } else {
                    // 否则和之前的前中序一样
                    stack.push(root);
                    root = root.right;
                }
            }
            return list;
        }
    }
}

package LeetCode;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 

public class 二叉树的中序遍历 {
// 中序遍历：左 根 右
// 前序遍历：根 左 右
// 后序遍历：左 右 根
    static class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            Iter(root);
            return list;
        }

        public void Iter(TreeNode root) {
            if (root == null) {
                return;
            }
            Iter(root.left);
            list.add(root.val);
            Iter(root.right);
        }
    }
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }
    }
}
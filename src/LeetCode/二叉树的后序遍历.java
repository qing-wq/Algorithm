package LeetCode;

import com.sun.org.apache.regexp.internal.REUtil;
import jdk.nashorn.internal.runtime.ListAdapter;
import sun.reflect.generics.tree.Tree;

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
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
                if (root != null) {
                    list.add(root.val);
                }
            }
            return list;
        }
    }
}

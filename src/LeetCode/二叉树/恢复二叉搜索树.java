package LeetCode.二叉树;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class 恢复二叉搜索树 {
    class Solution {
        public void recoverTree(TreeNode root) {
            // 中序遍历：左 根 右
            inorderTraversal(root);
            // 交换两个节点的值，而不是两个节点
            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;
        }

        TreeNode pre = null,t1,t2;
        private void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            if (pre != null && pre.val > root.val) {
                if(t1 == null) t1 = pre;
                t2 = root;
            }
            pre = root;
            inorderTraversal(root.right);
        }
    }
}

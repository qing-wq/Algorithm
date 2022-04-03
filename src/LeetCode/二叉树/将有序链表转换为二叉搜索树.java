package LeetCode.二叉树;

import java.util.List;
import java.util.SortedMap;
import java.util.logging.Level;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 将有序链表转换为二叉搜索树 {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            // 最开始的思路：将链表中的节点值保存在数组中
//            int[] arr = new int[20000];
            return dfs(head,null);
        }

        private TreeNode dfs(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
//            int mid = left + right >> 1;
            // 优化：使用快慢指针找到中间节点
            ListNode s = left;
            ListNode f = left;
            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }
            TreeNode root = new TreeNode(s.val);
            root.left = dfs(left, s);
            root.right = dfs(s, right);
            return root;
        }
    }
}

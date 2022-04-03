package LeetCode.二叉树;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class 将有序链表转换为二叉搜索树 {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            ListNode p = head;
            int[] arr = new int[20000];
            int n = 0;
            while (p != null) {
                arr[n++] = p.val;
                p = p.next;
            }
            return dfs(arr,0,n);
        }

        private TreeNode dfs(int[] arr, int left, int right) {
            if (left >= right) {
                return null;
            }
            int mid = left + right >> 1;
            TreeNode root = new TreeNode(arr[mid]);
            root.left = dfs(arr, left, mid);
            root.right = dfs(arr, mid + 1, right);
            return root;
        }
    }
}

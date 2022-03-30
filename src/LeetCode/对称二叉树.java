package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class 对称二叉树 {
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        //[1,2,2,null,3,null,3]
        Boolean res = new Solution().isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3, null, null)),
                new TreeNode(2, null, new TreeNode(3, null, null))));
//        Boolean res = new Solution().isSymmetric(new TreeNode(1, null, null));
//        Boolean res = new Solution().isSymmetric(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(2, null, null)));
        System.out.println(res);
        System.out.println();
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println("-------------");
        System.out.println(new TreeNode(1, null, null).equals(new TreeNode(1, null, null)));
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
    }

     static class Solution {
        public  boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            furIter(root.left, list1);

            Iter(root.right, list2);

            return list1.equals(list2);
        }

        private void furIter(TreeNode root, List<Integer> list) {
            // 中序遍历
            if (root == null) {
                list1.add(null);
                return;
            }
            list1.add(root.val);
            furIter(root.left, list1);
            furIter(root.right, list1);
        }

        private void Iter(TreeNode root, List<Integer> list) {
            // 后序遍历
            if (root == null) {
                list2.add(null);
                return;
            }
            list2.add(root.val);
            Iter(root.right, list1);
            Iter(root.left, list1);
        }
    }

    class Solution2 {
        public  boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return bool(root.left, root.right);
        }

        private boolean bool(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            return bool(left.left, right.right) && bool(left.right,right.left);
        }

    }
}

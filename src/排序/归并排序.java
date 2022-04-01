package 排序;

import java.util.Arrays;

public class 归并排序 {
    public static int[] SortArray(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // 分治
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        // 归并
        return merge(SortArray(left), SortArray(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        // 双指针，对左右数组每个元素依次比较，较小的加入res
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) {
                // 左边的数组已经被选择完
                res[index] = right[j++];
            } else if (j >= right.length) {
                // 右边的数组已经被选择完
                res[index] = left[i++];
            } else if (left[i] < right[j]) {
                res[index] = left[i++];
            } else {
                res[index] = right[j++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 2, 4, 1, 7, 5};
        int[] res = new 归并排序().SortArray(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

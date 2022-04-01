package 排序;

import java.util.Arrays;

public class 归并排序 {
    public static int[] SortArray(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(SortArray(left), SortArray(right));
    }

    private static int[] merge(int[] left, int[] right) {
        return new int[0];
    }
}

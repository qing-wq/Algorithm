package 排序;

import java.util.Scanner;

public class 归并排序2 {
    // 创建一个临时数组保存数据
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        merge(num, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
    }

    /*改进：
     * 不需要再开两个数组，直接用原数组和对应下标代替，节约内存
     * */
    private static void merge(int[] num, int l, int r) {
        // 边界条件
        if (l >= r) {
            return;
        }
        int mid = l + r >> 1;
        // ==============递归分治============
        merge(num, l, mid);
        merge(num, mid+1, r);

        // ============归并============
        // 双指针
        // 左数组从起始位置开始，右数组从中间位置开始
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (num[i] < num[j]) {
                temp[k++] = num[i++];
            } else {
                temp[k++] = num[j++];
            }
        }
        // 将未循环完的数组全加到temp末尾
        while (i <= mid) temp[k++] = num[i++];
        while (j <= r) temp[k++] = num[j++];

        for (int m = l, n = 0; m <= r; m++, n++) {
            num[m] = temp[n];
        }
    }
}

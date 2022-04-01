package 排序;

public class 希尔排序 {
    public static int[] SortArray(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int len = arr.length;
        // currentValue指示当前元素，gap指示分组间隔
        int currentValue, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                // 组内已经排序好的元素
                int preIndex = i - gap;
                currentValue = arr[i];
                while (preIndex >= 0 && currentValue < arr[preIndex]) { // 这里要将preIndex >= 0放在&&前面，不然会报越界错误
                    // 将排序好的元素后移一位
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // 插入当前元素
                arr[preIndex + gap] = currentValue;
            }
            gap /= 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 1,6};
        new 希尔排序().SortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
